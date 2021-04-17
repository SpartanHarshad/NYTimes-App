package com.example.nytimes.model.list_of_search_articles_dto


import com.google.gson.annotations.SerializedName

data class SearchArticleItemDto(
    @SerializedName("copyright")
    var copyright: String? = null,
    @SerializedName("response")
    var response: Response? = null,
    @SerializedName("status")
    var status: String? = null
)