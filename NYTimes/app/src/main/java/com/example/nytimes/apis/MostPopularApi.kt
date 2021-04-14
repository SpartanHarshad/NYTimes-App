package com.example.nytimes.apis

import com.example.nytimes.model.MostPopular
import retrofit2.http.GET
import retrofit2.http.Headers

interface MostPopularApi {

    @Headers("Accept: application/json")
    @GET("/mostpopular/v2/shared/1/facebook.json?api-key=JlslRyzODmDGRTHOAGfwCKfPrawZ7dLM")
    suspend fun getMostPopularNews():MostPopular
}