package com.example.nytimes.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nytimes.R
import com.example.nytimes.clickListeners.OnClickOfNews
import com.example.nytimes.local.entity.ArticleItemEntity
import kotlinx.android.synthetic.main.grid_news_item.view.*

class GridNewsAdapter (val newsList:List<ArticleItemEntity>, val onClickOfNews: OnClickOfNews):
    RecyclerView.Adapter<GridNewsHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridNewsHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.grid_news_item,parent,false)
        return GridNewsHolder(view, onClickOfNews)
    }

    override fun onBindViewHolder(holder: GridNewsHolder, position: Int) {
        val articleItemEntity: ArticleItemEntity = newsList[position]
        holder.setNews(articleItemEntity)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }
}

class GridNewsHolder(val view: View, val onClickOfNews: OnClickOfNews): RecyclerView.ViewHolder(view){

    fun setNews(articleItemEntity: ArticleItemEntity) {
        view.apply {
            tvNewsTitleGrid.text = articleItemEntity.title
            tvSectionGrid.text = "REAL ESTATE"
        }

        view.apply {
            Glide.with(ivNewsImgGrid)
                .load(articleItemEntity.image_low)
                .into(ivNewsImgGrid)
        }

        view.apply {
            llNews.setOnClickListener {
                onClickOfNews.getNews(articleItemEntity)
            }
        }
    }
}