package com.example.nytimes.model.search_result_dto


import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("docs")
    var docs: List<Doc>?,
    @SerializedName("meta")
    var meta: Meta?
)