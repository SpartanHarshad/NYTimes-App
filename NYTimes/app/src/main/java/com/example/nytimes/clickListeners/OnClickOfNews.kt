package com.example.nytimes.clickListeners

import android.graphics.Bitmap
import com.example.nytimes.local.entity.ArticleItemEntity

interface OnClickOfNews {

    fun getNews(result: ArticleItemEntity)
    fun forwardNews(url: String,image:Bitmap? = null)
}