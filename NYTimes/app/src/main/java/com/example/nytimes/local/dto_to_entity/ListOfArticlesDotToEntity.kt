package com.example.nytimes.local.dto_to_entity

import com.example.nytimes.local.entity.ArticleItemEntity
import com.example.nytimes.model.list_of_articles_dto.ArticleItemDto

class ListOfArticlesDotToEntity {
    companion object {
        fun ArticleItemDtoToEntity(data: ArticleItemDto): ArrayList<ArticleItemEntity> {

            val finalList = arrayListOf<ArticleItemEntity>()

            for (article in data.results!!) {

                finalList.add(
                    ArticleItemEntity(
                        subsection = article.subsection,
                        title = article.title,
                        url = article.url,
                        uri = article.uri,
                        byline = article.byline,
                        item_type = article.itemType,
                        updated_date = article.updatedDate,
                        created_date = article.createdDate,
                        published_date = article.publishedDate,
                        image_low = article.multimedia?.get(3)?.url,
                        image_high = article.multimedia?.get(0)?.url

                    )
                )
            }
            return finalList;
        }
    }
}
