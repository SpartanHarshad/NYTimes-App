package com.example.nytimes.repository

import androidx.room.withTransaction
import com.example.nytimes.local.database.NewsDatabase
import com.example.nytimes.local.dto_to_entity.ListOfArticlesDotToEntity
import com.example.nytimes.remote.network.NewsApi
import com.example.nytimes.util.networkBoundResource
import javax.inject.Inject

class PoliticsRepo@Inject constructor(
    private val api: NewsApi,
    private val db: NewsDatabase) {

    private val newsDao = db.getDao()

    fun getPoliticsNews(topic: String) = networkBoundResource(
        query = {
            newsDao.getAll(topic)
        },
        fetch = {
            ListOfArticlesDotToEntity.ArticleItemDtoToEntity(api.getPoliticsNews(topic), topic)
        },
        saveFetchResult = { news ->
            db.withTransaction {
                newsDao.deleteAll(topic)
                newsDao.insertItem(news)
            }
        }
    )
}