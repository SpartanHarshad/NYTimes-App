package com.example.nytimes.local.dto_to_entity

import android.util.Log
import com.example.nytimes.local.entity.ArticleItemEntity
import com.example.nytimes.model.list_of_search_articles_dto.SearchArticleItemDto

class ListSearchArticleItemDtoToEntity {

    companion object {

        fun ArticleItemDtoToEntity(data: SearchArticleItemDto, type: String): List<ArticleItemEntity> {

            val finalList = arrayListOf<ArticleItemEntity>()

            for (article in data.response!!.docs!!) {

                Log.d("tagsearch", "${(data.response!!.docs?.get(0)!!.abstract) }");

                finalList.add(
                    ArticleItemEntity(
                        subsection = article.sectionName,
                        title = article.headline!!.main,
                        abstractt = article.abstract,
                        url = article.webUrl,
                        uri = article.uri,
                        byline = article.keywords!!.get(0).value,
                        item_type = article.newsDesk,
                        updated_date = article.pubDate,
                        created_date = article.pubDate,
                        published_date = article.pubDate,
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