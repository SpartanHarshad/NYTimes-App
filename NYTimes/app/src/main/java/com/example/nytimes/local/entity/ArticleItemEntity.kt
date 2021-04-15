package com.example.nytimes.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "newsTable")
data class ArticleItemEntity(
    @ColumnInfo(name = "subsection") var subsection: String?,
    @ColumnInfo(name = "title") var title: String?,
    @ColumnInfo(name = "url") var url: String?,
    @ColumnInfo(name = "uri") var uri: String?,
    @ColumnInfo(name = "byline") var byline: String?,
    @ColumnInfo(name = "item_type") var item_type: String?,
    @ColumnInfo(name = "updated_date") var updated_date: String?,
    @ColumnInfo(name = "created_date") var created_date: String?,
    @ColumnInfo(name = "published_date") var published_date: String?,
    @ColumnInfo(name = "image_low") var image_low: String?,
    @ColumnInfo(name = "image_high") var image_high: String?,
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int? = null
}