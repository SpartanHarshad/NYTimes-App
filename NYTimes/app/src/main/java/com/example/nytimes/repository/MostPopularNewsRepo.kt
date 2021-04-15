package com.example.nytimes.repository


import com.example.nytimes.apis.MostPopularApi
import com.example.nytimes.model.MostPopular
import com.example.nytimes.remote.RetrofitGenerator


class MostPopularNewsRepo() {

    val newsApi = RetrofitGenerator.getInstance().create(MostPopularApi::class.java)

    suspend fun getMostPopularNews(): MostPopular {
        val Result  = newsApi.getMostPopularNews()
        return Result
    }
}
