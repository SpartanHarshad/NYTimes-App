package com.example.nytimes.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.nytimes.local.entity.ArticleItemEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {

    @Query("SELECT * FROM newsTable where type =:type")
    fun getAll(type: String?): Flow<List<ArticleItemEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(article: List<ArticleItemEntity>)

    @Query("DELETE FROM newsTable where type =:type")
    suspend fun deleteAll(type: String?)

}