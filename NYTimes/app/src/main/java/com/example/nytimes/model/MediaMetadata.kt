package com.example.nytimes.model


import com.google.gson.annotations.SerializedName

data class MediaMetadata(
    @SerializedName("format")
    var format: String? = null,
    @SerializedName("height")
    var height: Int? = null,
    @SerializedName("url")
    var url: String? = null,
    @SerializedName("width")
    var width: Int? = null
)