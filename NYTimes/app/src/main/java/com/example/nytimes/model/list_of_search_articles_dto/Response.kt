package com.example.nytimes.model.list_of_search_articles_dto


import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("docs")
    var docs: List<Doc>? = null,
    @SerializedName("meta")
    var meta: Meta? = null
)