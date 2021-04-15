package com.example.nytimes.model.list_of_articles_dto


import com.google.gson.annotations.SerializedName

data class ArticleItemDto(
    @SerializedName("copyright")
    var copyright: String?,
    @SerializedName("last_updated")
    var lastUpdated: String?,
    @SerializedName("num_results")
    var numResults: Int?,
    @SerializedName("results")
    var results: List<Result>?,
    @SerializedName("section")
    var section: String?,
    @SerializedName("status")
    var status: String?
)