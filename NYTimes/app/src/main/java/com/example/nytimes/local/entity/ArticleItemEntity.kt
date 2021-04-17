package com.example.nytimes.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "newsTable")
data class ArticleItemEntity(
    @ColumnInfo(name = "subsection") var subsection: String? = "nan",
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "title") var title: String = "nan",
    @ColumnInfo(name = "url") var url: String? = "nan",
    @ColumnInfo(name = "uri") var uri: String? = "nan",
    @ColumnInfo(name = "byline") var byline: String? = "nan",
    @ColumnInfo(name = "item_type") var item_type: String? = "nan",
    @ColumnInfo(name = "updated_date") var updated_date: String? = "nan",
    @ColumnInfo(name = "created_date") var created_date: String? = "nan",
    @ColumnInfo(name = "published_date") var published_date: String? = "nan",
    @ColumnInfo(name = "image_low") var image_low: String? = "nan",
    @ColumnInfo(name = "image_high") var image_high: String? = "nan",
    @ColumnInfo(name = "abstract") var abstractt: String? = "nan",
    @ColumnInfo(name = "type") var type: String? = "nan",
) {

   /* @ColumnInfo(name = "id")
    var id: Int? = null*/


}