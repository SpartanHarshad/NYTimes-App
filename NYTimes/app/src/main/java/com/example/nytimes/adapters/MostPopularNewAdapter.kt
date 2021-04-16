package com.example.nytimes.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nytimes.R
import com.example.nytimes.clickListeners.OnClickOfNews
import com.example.nytimes.local.entity.ArticleItemEntity
import com.example.nytimes.viewholder.MostPopularNewsViewHolder

class MostPopularNewAdapter(val mostPopularNewsList: List<ArticleItemEntity>, val onClickOfMostPopularNews: OnClickOfNews
) : RecyclerView.Adapter<MostPopularNewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MostPopularNewsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.news_item_layout, parent, false)
        return MostPopularNewsViewHolder(view, onClickOfMostPopularNews)
    }

    override fun onBindViewHolder(holder: MostPopularNewsViewHolder, position: Int) {
        val result: ArticleItemEntity = mostPopularNewsList[position]
        holder.setMostPopularNews(result,position)
    }

    override fun getItemCount(): Int {
        return mostPopularNewsList.size
    }
}
