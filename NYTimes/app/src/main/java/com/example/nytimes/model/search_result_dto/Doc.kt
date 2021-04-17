package com.example.nytimes.model.search_result_dto


import com.google.gson.annotations.SerializedName

data class Doc(
    @SerializedName("abstract")
    var `abstract`: String?,
    @SerializedName("byline")
    var byline: Byline?,
    @SerializedName("document_type")
    var documentType: String?,
    @SerializedName("headline")
    var headline: Headline?,
    @SerializedName("_id")
    var id: String?,
    @SerializedName("keywords")
    var keywords: List<Keyword>?,
    @SerializedName("lead_paragraph")
    var leadParagraph: String?,
    @SerializedName("multimedia")
    var multimedia: List<Multimedia>?,
    @SerializedName("news_desk")
    var newsDesk: String?,
    @SerializedName("print_page")
    var printPage: String?,
    @SerializedName("print_section")
    var printSection: String?,
    @SerializedName("pub_date")
    var pubDate: String?,
    @SerializedName("section_name")
    var sectionName: String?,
    @SerializedName("snippet")
    var snippet: String?,
    @SerializedName("source")
    var source: String?,
    @SerializedName("subsection_name")
    var subsectionName: String?,
    @SerializedName("type_of_material")
    var typeOfMaterial: String?,
    @SerializedName("uri")
    var uri: String?,
    @SerializedName("web_url")
    var webUrl: String?,
    @SerializedName("word_count")
    var wordCount: Int?
)