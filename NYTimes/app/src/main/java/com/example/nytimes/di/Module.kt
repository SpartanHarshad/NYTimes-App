package com.example.nytimes.di

import android.app.Application
import androidx.room.Room
import com.example.nytimes.local.database.NewsDatabase
import com.example.nytimes.remote.network.NewsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
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
        return Room.databaseBuilder(app, NewsDatabase::class.java, "newDatabase")
            .fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(NewsApi.Base_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun providesNewsApi(retrofit: Retrofit): NewsApi =
        retrofit.create(NewsApi::class.java)

}