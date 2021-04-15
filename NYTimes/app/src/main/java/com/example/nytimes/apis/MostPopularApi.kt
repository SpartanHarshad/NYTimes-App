package com.example.nytimes.apis

import com.example.nytimes.model.MostPopular
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface MostPopularApi {

    @GET("/svc/mostpopular/v2/emailed/7.json?api-key=qGsGVGo1uAd79EqmcXLywnJ6njPHK4fS")
    suspend fun getMostPopularNews():MostPopular
}