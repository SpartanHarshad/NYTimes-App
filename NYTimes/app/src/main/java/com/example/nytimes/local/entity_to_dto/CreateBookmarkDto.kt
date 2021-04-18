package com.example.nytimes.local.entity_to_dto

import com.example.nytimes.local.entity.ArticleItemEntity
import com.example.nytimes.model.bookmark_dto.BookmarkDtoItem

class CreateBookmarkDto {
    companion object {
        fun createBookmark(articleItemEntity: ArticleItemEntity, email: String): BookmarkDtoItem {
            return BookmarkDtoItem(
                subsection = articleItemEntity.subsection,
                title = articleItemEntity.title,
                url = articleItemEntity.url,
                uri = articleItemEntity.uri,
                byline = articleItemEntity.byline,
                itemType = articleItemEntity.item_type,
                updatedDate = articleItemEntity.updated_date,
                createdDate = articleItemEntity.created_date,
                publishedDate = articleItemEntity.published_date,
                imageLow = articleItemEntity.image_low,
                imageHigh = articleItemEntity.image_high,
                abstractt = articleItemEntity.abstractt,
                type = articleItemEntity.type,
                id = articleItemEntity.title + email,
                email = email
            )
        }
    }
}

