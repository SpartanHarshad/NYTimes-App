package com.example.nytimes.model.list_of_articles_dto


import com.google.gson.annotations.SerializedName

data class Multimedia(
    @SerializedName("caption")
    var caption: String?,
    @SerializedName("copyright")
    var copyright: String?,
    @SerializedName("format")
    var format: String?,
    @SerializedName("height")
    var height: Int?,
    @SerializedName("subtype")
    var subtype: String?,
    @SerializedName("type")
    var type: String?,
    @SerializedName("url")
    var url: String?,
    @SerializedName("width")
    var width: Int?
)