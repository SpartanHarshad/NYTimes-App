package com.example.nytimes.model.search_result_dto


import com.google.gson.annotations.SerializedName

data class Person(
    @SerializedName("firstname")
    var firstname: String?,
    @SerializedName("lastname")
    var lastname: String?,
    @SerializedName("middlename")
    var middlename: Any?,
    @SerializedName("organization")
    var organization: String?,
    @SerializedName("qualifier")
    var qualifier: Any?,
    @SerializedName("rank")
    var rank: Int?,
    @SerializedName("role")
    var role: String?,
    @SerializedName("title")
    var title: Any?
)