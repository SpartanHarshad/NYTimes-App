package com.example.nytimes.model


import com.google.gson.annotations.SerializedName

data class MostPopular(
    @SerializedName("copyright")
    var copyright: String? = null,
    @SerializedName("num_results")
    var numResults: Int? = null,
    @SerializedName("results")
    var results: List<Result>? = null,
    @SerializedName("status")
    var status: String? = null
)