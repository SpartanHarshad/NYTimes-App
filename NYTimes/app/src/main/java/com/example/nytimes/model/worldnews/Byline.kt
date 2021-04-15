package com.example.nytimes.model.worldnews


import com.google.gson.annotations.SerializedName

data class Byline(
    @SerializedName("organization")
    var organization: Any? = null,
    @SerializedName("original")
    var original: String? = null,
    @SerializedName("person")
    var person: List<Person>? = null
)