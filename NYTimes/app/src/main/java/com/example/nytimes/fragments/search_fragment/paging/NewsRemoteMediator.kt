package com.example.nytimes.fragments.search_fragment.paging

import android.util.Log
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.example.nytimes.local.database.NewsDatabase
import com.example.nytimes.local.dto_to_entity.SearchResultDtoToEntity
import com.example.nytimes.local.entity.ArticleItemEntity
import com.example.nytimes.local.entity.ArticleRemoteKey
import com.example.nytimes.remote.network.NewsApi
import java.io.InvalidObjectException

@ExperimentalPagingApi
class NewsRemoteMediator(
    private val newsDb: NewsDatabase,
    private val newsApi: NewsApi,
    private val initialPage: Int = 1,
    private val type: String
) : RemoteMediator<Int, ArticleItemEntity>() {
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, ArticleItemEntity>
    ): MediatorResult {


        return try {
            val page = when (loadType) {
                LoadType.APPEND -> {
                    Log.d("fgd", "APPEND")
                    val remoteKey =
                        getLastKey(state) ?: throw InvalidObjectException("invalid object")
                    remoteKey.next ?: return MediatorResult.Success(endOfPaginationReached = true)

                }
                LoadType.PREPEND -> {
                    Log.d("fgd", "PREPEND")
                    return MediatorResult.Success(endOfPaginationReached = true)
                }
                LoadType.REFRESH -> {
                    Log.d("fgd", "REFRESH")
                    val remoteKey = getCloseKey(state)
                    remoteKey?.next?.minus(1) ?: initialPage
                }
            }
            val response = newsApi.searchNews(type, page) //here

            val finalList =
                SearchResultDtoToEntity.ArticleItemDtoToEntity(response.body(), type)



            Log.d("fgd", "thing")
            val endOfPagination = response.body()?.response?.docs?.size ?: 0 < state.config.pageSize

            if (response.isSuccessful) {

                if (loadType == LoadType.REFRESH) {
                    newsDao.deleteAll(type) //here
                    newsDao.deleteAllRemoteKey(type) //here
                }

                val prev = if (page == initialPage) null else page - 1
                val next = if (endOfPagination) null else page + 1

                val list = response.body()?.response?.docs?.map {
                    ArticleRemoteKey(it.headline!!.main!!, prev, next, type)
                }

                if (list != null) {
                    newsDao.insertAllRemoteKey(list) // here
                }

                newsDao.insertItem(finalList)

                MediatorResult.Success(endOfPagination)
            } else {
                MediatorResult.Success(endOfPaginationReached = true)
            }


        } catch (e: Exception) {
            Log.d("fgd", e.message + "" + e.localizedMessage + e.cause)
            MediatorResult.Error(e)
        }
    }

    private val newsDao = newsDb.getDao()
    private suspend fun getCloseKey(state: PagingState<Int, ArticleItemEntity>): ArticleRemoteKey? {
        return state.anchorPosition?.let {
            state.closestItemToPosition(it)?.let {
                newsDao.getAllRemoteKey(it.title)
            }
        }
    }

    private suspend fun getLastKey(state: PagingState<Int, ArticleItemEntity>): ArticleRemoteKey? {

        return state.lastItemOrNull()?.let {
            newsDao.getAllRemoteKey(it.title)
        }
    }

}