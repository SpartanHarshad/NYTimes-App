package com.example.nytimes.model.bookmark_dto


import com.google.gson.annotations.SerializedName

data class BookmarkDtoItem(
    @SerializedName("abstractt")
    var abstractt: String?,
    @SerializedName("byline")
    var byline: String?,
    @SerializedName("created_date")
    var createdDate: String?,
    @SerializedName("email")
    var email: String?,
    @SerializedName("id")
    var id: String?,
    @SerializedName("image_high")
    var imageHigh: String?,
    @SerializedName("image_low")
    var imageLow: String?,
    @SerializedName("item_type")
    var itemType: String?,
    @SerializedName("published_date")
    var publishedDate: String?,
    @SerializedName("subsection")
    var subsection: String?,
    @SerializedName("title")
    var title: String?,
    @SerializedName("type")
    var type: String?,
    @SerializedName("updated_date")
    var updatedDate: String?,
    @SerializedName("uri")
    var uri: String?,
    @SerializedName("url")
    var url: String?
)