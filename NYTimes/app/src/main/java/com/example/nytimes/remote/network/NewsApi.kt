package com.example.nytimes.remote.network


import com.example.nytimes.model.list_of_articles_dto.ArticleItemDto
import com.example.nytimes.model.search_result_dto.SearchResultDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NewsApi {

    companion object {

        const val Base_URL = "https://api.nytimes.com/"

        const val API_KEY = "IttSSA4wL8eTAxOV8FRpD6Kk0lWAzUaO"
        //const val API_KEY = "qGsGVGo1uAd79EqmcXLywnJ6njPHK4fS"
    }


    @GET("svc/topstories/v2/{topic}.json?api-key=$API_KEY")
    suspend fun getNews(@Path("topic") topic: String): ArticleItemDto

    @GET("svc/search/v2/articlesearch.json")
    suspend fun searchNews(
        @Query("q") topic: String,
        @Query("page") pageSize: Int,
        @Query("api-key") apikey: String = API_KEY
    ): Response<SearchResultDto>






    @GET("/svc/{topic}/v2/emailed/1.json?api-key=${API_KEY}")
    suspend fun getMostPopularNews(@Path("topic") topic: String): ArticleItemDto

    @GET("svc/topstories/v2/{topic}.json?api-key=$API_KEY")
    suspend fun getWorldNews(@Path("topic")topic :String): ArticleItemDto

    @GET("svc/topstories/v2/{topic}.json?api-key=$API_KEY")
    suspend fun getUSNews(@Path("topic")topic :String): ArticleItemDto

    @GET("svc/topstories/v2/{topic}.json?api-key=$API_KEY")
    suspend fun getPoliticsNews(@Path("topic")topic :String): ArticleItemDto

}