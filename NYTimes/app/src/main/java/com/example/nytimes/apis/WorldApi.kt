package com.example.nytimes.apis

import com.example.nytimes.model.worldnews.WorldNews
import retrofit2.http.GET

interface WorldApi {

    @GET("/svc/search/v2/articlesearch.json?q=world&api-key=qGsGVGo1uAd79EqmcXLywnJ6njPHK4fS")
    suspend fun getWorldNews(): WorldNews
}