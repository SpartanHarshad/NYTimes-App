package com.example.nytimes.model.search_result_dto


import com.google.gson.annotations.SerializedName

data class Headline(
    @SerializedName("content_kicker")
    var contentKicker: Any?,
    @SerializedName("kicker")
    var kicker: Any?,
    @SerializedName("main")
    var main: String?,
    @SerializedName("name")
    var name: Any?,
    @SerializedName("print_headline")
    var printHeadline: Any?,
    @SerializedName("seo")
    var seo: Any?,
    @SerializedName("sub")
    var sub: Any?
)