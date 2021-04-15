package com.example.nytimes.model.worldnews


import com.google.gson.annotations.SerializedName

data class Person(
    @SerializedName("firstname")
    var firstname: String? = null,
    @SerializedName("lastname")
    var lastname: String? = null,
    @SerializedName("middlename")
    var middlename: Any? = null,
    @SerializedName("organization")
    var organization: String? = null,
    @SerializedName("qualifier")
    var qualifier: Any? = null,
    @SerializedName("rank")
    var rank: Int? = null,
    @SerializedName("role")
    var role: String? = null,
    @SerializedName("title")
    var title: Any? = null
)