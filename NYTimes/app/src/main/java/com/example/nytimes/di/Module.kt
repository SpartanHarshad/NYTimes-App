package com.example.nytimes.di

import android.app.Application
import androidx.room.Room
import com.example.nytimes.local.database.NewsDatabase
import com.example.nytimes.remote.network.NewsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class Module {

    @Provides
    @Singleton
    fun providesDatabase(
        app: Application
    ): NewsDatabase {
        return Room.databaseBuilder(app, NewsDatabase::class.java, "newsDatabase")
            .fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit {

        val httpLoggingInterceptor =
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)


        return Retrofit.Builder()
            .baseUrl(NewsApi.Base_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build())
            .build()
    }


    @Provides
    @Singleton
    fun providesNewsApi(retrofit: Retrofit): NewsApi =
        retrofit.create(NewsApi::class.java)

}