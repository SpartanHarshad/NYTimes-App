package com.example.nytimes.worker

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.nytimes.R
import com.example.nytimes.model.bookmark_dto.BookmarkDtoItem
import com.example.nytimes.remote.network.BookmarkApi
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BOOKMARK_INSERT = 1
const val BOOKMARK_REMOVE = 0

class BookmarkWork(context: Context, workerParams: WorkerParameters) :
    CoroutineWorker(context, workerParams) {

    /*  @Inject
      lateinit var bookmarkApi: BookmarkApi
  */

    override suspend fun doWork(): Result {

        val httpLoggingInterceptor =
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        val retrofit = Retrofit.Builder()
            .baseUrl(BookmarkApi.Base_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build())
            .build()

        var bookmarkApi = retrofit.create(BookmarkApi::class.java)

        val data = inputData.getString("data")
        val type = inputData.getInt("type", -1)
        val gson = Gson()
        val bookmark = gson.fromJson(data, BookmarkDtoItem::class.java)

        dislayNotification("Update bookmark databse", "updated ${bookmark.title}")

        if (type == BOOKMARK_INSERT) {
            bookmarkApi.insertBookmark(bookmark)
        } else {
            bookmark.id?.let { bookmarkApi.deleteBookmark(it) }
        }

        return Result.success()
    }

    private fun dislayNotification(task: String, desc: String) {
        val notificationManager =
            applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel = NotificationChannel(
                "workExample",
                "workExample",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            notificationManager.createNotificationChannel(notificationChannel)
        }
        val builder = NotificationCompat.Builder(applicationContext, "workExample")
            .setContentTitle(task)
            .setContentText(desc)
            .setSmallIcon(R.mipmap.ic_launcher)
        notificationManager.notify(1, builder.build())
    }

}