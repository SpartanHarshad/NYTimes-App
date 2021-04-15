package com.example.nytimes.model.worldnews


import com.google.gson.annotations.SerializedName

data class WorldNews(
    @SerializedName("copyright")
    var copyright: String? = null,
    @SerializedName("response")
    var response: Response? = null,
    @SerializedName("status")
    var status: String? = null
)