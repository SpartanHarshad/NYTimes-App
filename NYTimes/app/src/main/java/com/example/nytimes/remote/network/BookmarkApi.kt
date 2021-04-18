package com.example.nytimes.remote.network

import com.example.nytimes.model.bookmark_dto.BookmarkDto
import com.example.nytimes.model.bookmark_dto.BookmarkDtoItem
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface BookmarkApi {

    companion object {
        const val Base_URL = " https://d972c6935f2f.ngrok.io"
    }

    @POST("/insertBookMark")
    suspend fun insertBookmark(@Body bookmark: BookmarkDtoItem)

    @GET("/deleteBookMark/{id}")
    suspend fun deleteBookmark(@Path("id") id: String)

    @GET("/getAllBookMarks/{email}")
    suspend fun getAllBookMarks(@Path("email") email: String): BookmarkDto

}