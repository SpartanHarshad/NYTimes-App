package com.example.nytimes.model.worldnews


import com.google.gson.annotations.SerializedName

data class Keyword(
    @SerializedName("major")
    var major: String? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("rank")
    var rank: Int? = null,
    @SerializedName("value")
    var value: String? = null
)