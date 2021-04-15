package com.example.nytimes.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.nytimes.model.Article


@Database(
        entities = [Article::class],
        version = 1
)
@TypeConverters(Converter::class)
abstract class ForYouDatabase : RoomDatabase() {

    abstract fun getArticleDao(): ForYouDao

    companion object {
        @Volatile
        private var instance: ForYouDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) =
                Room.databaseBuilder(
                        context.applicationContext,
                        ForYouDatabase::class.java,
                        "article_db.db"
                ).build()
    }
}