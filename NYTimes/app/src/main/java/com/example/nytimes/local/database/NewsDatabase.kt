package com.example.nytimes.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.nytimes.local.dao.NewsDao
import com.example.nytimes.local.entity.ArticleItemEntity

@Database(entities = [ArticleItemEntity::class], version = 1)
abstract class NewsDatabase() : RoomDatabase() {
    abstract fun getDao(): NewsDao
}
