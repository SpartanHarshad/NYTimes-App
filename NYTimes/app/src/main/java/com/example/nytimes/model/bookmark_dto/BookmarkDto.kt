package com.example.nytimes.model.bookmark_dto


import androidx.room.Entity

@Entity(tableName = "bookMarkTable")
class BookmarkDto : ArrayList<BookmarkDtoItem>()