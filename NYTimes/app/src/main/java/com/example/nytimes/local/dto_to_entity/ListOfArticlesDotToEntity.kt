package com.example.nytimes.local.dto_to_entity

import android.util.Log
import com.example.nytimes.local.entity.ArticleItemEntity
import com.example.nytimes.model.list_of_articles_dto.ArticleItemDto

class ListOfArticlesDotToEntity {
    companion object {
        fun ArticleItemDtoToEntity(data: ArticleItemDto, type: String): List<ArticleItemEntity> {

            val finalList = arrayListOf<ArticleItemEntity>()

            for (article in data.results!!) {

                Log.d("tag", "${(data.results?.size ?: 0) }");

                finalList.add(
                    ArticleItemEntity(
                        subsection = article.subsection,
                        title = article.title,
                        abstractt = article.abstract,
                        url = article.url,
                        uri = article.uri,
                        byline = article.byline,
                        item_type = article.itemType,
                        updated_date = article.updatedDate,
                        created_date = article.createdDate,
                        published_date = article.publishedDate,
                        image_low = article.multimedia?.get(0)?.url,
                        image_high = article.multimedia?.get(0)?.url,
                        type = type
                    )
                )
            }
            return finalList
        }
    }
}
