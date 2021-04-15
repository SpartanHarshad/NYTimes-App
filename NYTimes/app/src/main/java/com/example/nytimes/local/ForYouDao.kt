package com.example.nytimes.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.nytimes.model.Article


@Dao
interface ForYouDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article): Long

    @Query("SELECT * FROM foryou_table")
    fun getAllArticles(): LiveData<List<Article>>

    @Delete
    suspend fun deleteArticle(article: Article)
}