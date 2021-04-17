package com.example.nytimes.fragments.search_fragment.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.nytimes.local.dto_to_entity.SearchResultDtoToEntity
import com.example.nytimes.local.entity.ArticleItemEntity
import com.example.nytimes.remote.network.NewsApi

private const val START_PAGE = 1

class NewsPagingSource(
    private val news: NewsApi,
    private val query: String
) : PagingSource<Int, ArticleItemEntity>() {


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ArticleItemEntity> {
        val postion = params.key ?: START_PAGE

        return try {
            val response = SearchResultDtoToEntity.ArticleItemDtoToEntity(
                news.searchNews(query, postion).body(),
                query
            )
            LoadResult.Page(
                data = response!!,
                prevKey = if (postion == START_PAGE) null else postion - 1,
                nextKey = if (response.isEmpty()) null else postion + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, ArticleItemEntity>): Int? {
        return state.anchorPosition
    }

}