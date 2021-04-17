package com.example.nytimes.model.search_result_dto


import com.google.gson.annotations.SerializedName

data class Byline(
    @SerializedName("organization")
    var organization: Any?,
    @SerializedName("original")
    var original: String?,
    @SerializedName("person")
    var person: List<Person>?
)