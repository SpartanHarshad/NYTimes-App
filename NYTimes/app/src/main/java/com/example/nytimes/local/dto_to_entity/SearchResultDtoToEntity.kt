package com.example.nytimes.local.dto_to_entity

import android.util.Log
import com.example.nytimes.local.entity.ArticleItemEntity
import com.example.nytimes.model.search_result_dto.SearchResultDto

class SearchResultDtoToEntity {
    companion object {
        fun ArticleItemDtoToEntity(data: SearchResultDto?, type: String): List<ArticleItemEntity>? {

            val finalList = arrayListOf<ArticleItemEntity>()

            /*if (data != null) {
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
            }*/

            Log.d("asdas", "${finalList.size}")


            //https://static01.nyt.com/
            return data!!.response?.docs?.map {
                var name = "thingg"
                if (it.headline != null && it.headline!!.main != null) {
                    name = it.headline!!.main!!
                }
                var imageUrl = "dfd"

                ArticleItemEntity(
                    subsection = " it.subsectionName",
                    title = name,
                    abstractt = it.abstract,
                    url = it.webUrl,
                    uri = it.uri,
                    byline = it.byline?.original,
                    item_type = it.newsDesk,
                    updated_date = it.pubDate,
                    created_date = it.pubDate,
                    published_date = it.pubDate,
                    image_low = if (it.multimedia.isNullOrEmpty()) "nan" else "https://static01.nyt.com/" + it.multimedia!![0].url,
                    image_high = if (it.multimedia.isNullOrEmpty()) "nan" else "https://static01.nyt.com/" + it.multimedia!![0].url,
                    type = type
                )
            }

        }
    }
}