package com.example.nytimes.clickListeners

import android.graphics.Bitmap
import com.example.nytimes.local.entity.ArticleItemEntity
import com.example.nytimes.model.Result

interface OnClickOfNews {
    fun getNews(result: ArticleItemEntity)
    fun forwardNews(url: String,image: Bitmap? = null)
}