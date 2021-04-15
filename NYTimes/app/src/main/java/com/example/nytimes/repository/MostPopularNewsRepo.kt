package com.example.nytimes.repository


import com.example.nytimes.apis.MostPopularApi
import com.example.nytimes.model.MostPopular
import com.example.nytimes.remote.RetrofitGenerator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class MostPopularNewsRepo{

    suspend fun getMostPopularNews(): MostPopular {
        val mostPopularNewApi = RetrofitGenerator.getInstance().create(MostPopularApi::class.java)
        return mostPopularNewApi.getMostPopularNews()
    }
}
