package com.example.nytimes.model.search_result_dto


import com.google.gson.annotations.SerializedName

data class Meta(
    @SerializedName("hits")
    var hits: Int?,
    @SerializedName("offset")
    var offset: Int?,
    @SerializedName("time")
    var time: Int?
)