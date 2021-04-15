package com.example.nytimes.model.worldnews


import com.google.gson.annotations.SerializedName

data class Legacy(
    @SerializedName("thumbnail")
    var thumbnail: String? = null,
    @SerializedName("thumbnailheight")
    var thumbnailheight: Int? = null,
    @SerializedName("thumbnailwidth")
    var thumbnailwidth: Int? = null,
    @SerializedName("wide")
    var wide: String? = null,
    @SerializedName("wideheight")
    var wideheight: Int? = null,
    @SerializedName("widewidth")
    var widewidth: Int? = null,
    @SerializedName("xlarge")
    var xlarge: String? = null,
    @SerializedName("xlargeheight")
    var xlargeheight: Int? = null,
    @SerializedName("xlargewidth")
    var xlargewidth: Int? = null
)