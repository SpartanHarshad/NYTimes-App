package com.example.nytimes.repository

import com.example.nytimes.apis.WorldApi
import com.example.nytimes.model.worldnews.WorldNews
import com.example.nytimes.remote.RetrofitGenerator

class WorldNewsRepo {

    val newsApi = RetrofitGenerator.getInstance().create(WorldApi::class.java)

    suspend fun getWorldNews(): WorldNews {
        val Result  = newsApi.getWorldNews()
        return Result
    }
}