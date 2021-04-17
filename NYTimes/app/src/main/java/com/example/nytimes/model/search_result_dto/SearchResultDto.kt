package com.example.nytimes.model.search_result_dto


import com.google.gson.annotations.SerializedName

data class SearchResultDto(
    @SerializedName("copyright")
    var copyright: String?,
    @SerializedName("response")
    var response: Response?,
    @SerializedName("status")
    var status: String?
)