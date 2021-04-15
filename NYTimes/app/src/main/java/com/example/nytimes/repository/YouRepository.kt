package com.example.nytimes.repository

import com.example.nytimes.api.RetrofitInstance
import com.example.nytimes.local.ForYouDatabase
import com.example.nytimes.model.Article

class  YouRepository(
        val db: ForYouDatabase
) {
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
            RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)



    suspend fun upsert(article: Article)=db.getArticleDao().upsert(article)

    fun getSavedNews() =db.getArticleDao().getAllArticles()

    suspend fun deleteArticle(article: Article)=db.getArticleDao().deleteArticle(article)
}



