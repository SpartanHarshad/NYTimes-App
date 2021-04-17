package com.example.nytimes.local.dao

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.nytimes.local.entity.ArticleItemEntity
import com.example.nytimes.local.entity.ArticleRemoteKey
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {

    @Query("SELECT * FROM newsTable where type =:type")
    fun getAll(type: String?): Flow<List<ArticleItemEntity>>

    @Query("SELECT * FROM newsTable where type =:type")
    fun getAllSearch(type: String): PagingSource<Int, ArticleItemEntity>

    @Query("SELECT * FROM newsTable where title like :type")
    fun searchInCache(type: String): PagingSource<Int, ArticleItemEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(article: List<ArticleItemEntity>)

    @Query("DELETE FROM newsTable where type =:type")
    suspend fun deleteAll(type: String?)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllRemoteKey(list: List<ArticleRemoteKey>)

    @Query("SELECT * FROM ArticleRemoteKey WHERE id= :id")
    suspend fun getAllRemoteKey(id: String): ArticleRemoteKey?

    @Query("DELETE FROM ArticleRemoteKey")
    suspend fun deleteAllRemoteKey()

}