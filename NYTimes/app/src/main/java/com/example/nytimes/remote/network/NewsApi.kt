package com.example.nytimes.remote.network

import com.example.nytimes.model.list_of_articles_dto.ArticleItemDto

interface NewsApi {

    companion object {
        val Base_URL = "https://api.nytimes.com/svc/topstories/v2/"
    }

    suspend fun getNews(): ArticleItemDto


}