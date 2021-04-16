package com.example.nytimes.local.dto_to_entity

import android.util.Log
import com.example.nytimes.local.entity.ArticleItemEntity
import com.example.nytimes.model.search_result_dto.SearchResultDto

class SearchResultDtoToEntity {
    companion object {
        fun ArticleItemDtoToEntity(data: SearchResultDto?, type: String): List<ArticleItemEntity> {

            val finalList = arrayListOf<ArticleItemEntity>()

            if (data != null) {
                for (article in data.response?.docs!!) {

                    Log.d("taggg", "${(data.response?.docs?.size ?: 0)}")

                    article.headline?.main?.let {
                        ArticleItemEntity(
                            subsection = article.subsectionName,
                            title = it,
                            abstractt = article.abstract,
                            url = article.webUrl,
                            uri = article.uri,
                            byline = article.byline?.original,
                            item_type = article.newsDesk,
                            updated_date = article.pubDate,
                            created_date = article.pubDate,
                            published_date = article.pubDate,
                            image_low = "sdfs",
                            image_high = "article.multimedia?.get(0)?.url",
                            type = type
                        )
                    }?.let {
                        finalList.add(
                            it
                        )
                    }
                }
            }

            Log.d("asdas","${finalList.size}")

            return finalList
        }
    }
}