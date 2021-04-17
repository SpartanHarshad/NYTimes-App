package com.example.nytimes.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.nytimes.local.dao.NewsDao
import com.example.nytimes.local.entity.ArticleItemEntity
import com.example.nytimes.local.entity.ArticleRemoteKey

@Database(entities = [ArticleItemEntity::class,ArticleRemoteKey::class], version = 1)
abstract class NewsDatabase() : RoomDatabase() {
    abstract fun getDao(): NewsDao
}
