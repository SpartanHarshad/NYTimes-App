package com.example.nytimes.model.list_of_search_articles_dto


import com.google.gson.annotations.SerializedName

data class Doc(
    @SerializedName("abstract")
    var `abstract`: String? = null,
    @SerializedName("byline")
    var byline: Byline? = null,
    @SerializedName("document_type")
    var documentType: String? = null,
    @SerializedName("headline")
    var headline: Headline? = null,
    @SerializedName("_id")
    var id: String? = null,
    @SerializedName("keywords")
    var keywords: List<Keyword>? = null,
    @SerializedName("lead_paragraph")
    var leadParagraph: String? = null,
    @SerializedName("multimedia")
    var multimedia: List<Multimedia>? = null,
    @SerializedName("news_desk")
    var newsDesk: String? = null,
    @SerializedName("pub_date")
    var pubDate: String? = null,
    @SerializedName("section_name")
    var sectionName: String? = null,
    @SerializedName("snippet")
    var snippet: String? = null,
    @SerializedName("source")
    var source: String? = null,
    @SerializedName("type_of_material")
    var typeOfMaterial: String? = null,
    @SerializedName("uri")
    var uri: String? = null,
    @SerializedName("web_url")
    var webUrl: String? = null,
    @SerializedName("word_count")
    var wordCount: Int? = null
)