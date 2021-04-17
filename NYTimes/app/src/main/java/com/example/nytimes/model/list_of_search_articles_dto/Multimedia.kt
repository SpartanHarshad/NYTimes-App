package com.example.nytimes.model.list_of_search_articles_dto


import com.google.gson.annotations.SerializedName

data class Multimedia(
    @SerializedName("caption")
    var caption: Any? = null,
    @SerializedName("credit")
    var credit: Any? = null,
    @SerializedName("crop_name")
    var cropName: String? = null,
    @SerializedName("height")
    var height: Int? = null,
    @SerializedName("legacy")
    var legacy: Legacy? = null,
    @SerializedName("rank")
    var rank: Int? = null,
    @SerializedName("subType")
    var subType: String? = null,
    @SerializedName("subtype")
    var subtype: String? = null,
    @SerializedName("type")
    var type: String? = null,
    @SerializedName("url")
    var url: String? = null,
    @SerializedName("width")
    var width: Int? = null
)