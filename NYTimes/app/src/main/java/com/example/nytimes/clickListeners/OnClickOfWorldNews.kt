package com.example.nytimes.clickListeners

import com.example.nytimes.model.worldnews.Doc

interface OnClickOfWorldNews {

    fun getWorldNews(doc: Doc)
}