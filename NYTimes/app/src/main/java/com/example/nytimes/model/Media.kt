package com.example.nytimes.model


import com.google.gson.annotations.SerializedName

data class Media(
    @SerializedName("approved_for_syndication")
    var approvedForSyndication: Int? = null,
    @SerializedName("caption")
    var caption: String? = null,
    @SerializedName("copyright")
    var copyright: String? = null,
    @SerializedName("media-metadata")
    var mediaMetadata: List<MediaMetadata>? = null,
    @SerializedName("subtype")
    var subtype: String? = null,
    @SerializedName("type")
    var type: String? = null
)