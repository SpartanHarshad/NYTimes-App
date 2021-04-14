package com.example.nytimes.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitGenerator {

    fun <S> createService(serviceClass: Class<S>?): S {
        val retrofit: Retrofit = getInstance()
        return retrofit.create(serviceClass)
    }

    companion object {
        private val httpLoggingInterceptor =
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
         //https://api.nytimes.com/svc/mostpopular/v2/emailed/7.json?api-key=JlslRyzODmDGRTHOAGfwCKfPrawZ7dLM
        fun getInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl("https://api.nytimes.com/svc")
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build())
                .build()
        }
    }
}