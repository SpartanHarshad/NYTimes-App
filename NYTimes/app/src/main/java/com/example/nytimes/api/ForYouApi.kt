package com.example.nytimes.api

import com.example.nytimes.api.Constants.Companion.API_KEY
import com.example.nytimes.model.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ForYouApi {

    @GET("v2/top-headlines")
    suspend fun getBreakingNews(
            @Query("country")
            countryCode: String = "us",
            @Query("page")
            pageNumber: Int = 1,
            @Query("apiKey")
            apiKey: String = API_KEY
    ): Response<NewsResponse>

}