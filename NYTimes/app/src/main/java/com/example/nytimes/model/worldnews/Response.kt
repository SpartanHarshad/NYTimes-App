package com.example.nytimes.model.worldnews


import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("docs")
    var docs: List<Doc>? = null,
    @SerializedName("meta")
    var meta: Meta? = null
)