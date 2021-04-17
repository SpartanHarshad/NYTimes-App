package com.example.nytimes.model.list_of_search_articles_dto


import com.google.gson.annotations.SerializedName

data class Headline(
    @SerializedName("content_kicker")
    var contentKicker: Any? = null,
    @SerializedName("kicker")
    var kicker: Any? = null,
    @SerializedName("main")
    var main: String? = null,
    @SerializedName("name")
    var name: Any? = null,
    @SerializedName("print_headline")
    var printHeadline: Any? = null,
    @SerializedName("seo")
    var seo: Any? = null,
    @SerializedName("sub")
    var sub: Any? = null
)