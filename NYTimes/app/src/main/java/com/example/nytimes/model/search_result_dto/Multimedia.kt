package com.example.nytimes.model.search_result_dto


import com.google.gson.annotations.SerializedName

data class Multimedia(
    @SerializedName("caption")
    var caption: Any?,
    @SerializedName("credit")
    var credit: Any?,
    @SerializedName("crop_name")
    var cropName: String?,
    @SerializedName("height")
    var height: Int?,
    @SerializedName("legacy")
    var legacy: Legacy?,
    @SerializedName("rank")
    var rank: Int?,
    @SerializedName("subType")
    var subType: String?,
    @SerializedName("subtype")
    var subtype: String?,
    @SerializedName("type")
    var type: String?,
    @SerializedName("url")
    var url: String?,
    @SerializedName("width")
    var width: Int?
)