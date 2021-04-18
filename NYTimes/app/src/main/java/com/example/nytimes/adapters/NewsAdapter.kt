package com.example.nytimes.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nytimes.R
import com.example.nytimes.clickListeners.OnClickOfNews
import com.example.nytimes.local.entity.ArticleItemEntity
import com.example.nytimes.util.BitMapCreator
import kotlinx.android.synthetic.main.news_item_layout.view.*

class NewsAdapter(val newsList:List<ArticleItemEntity>, val onClickOfNews: OnClickOfNews):RecyclerView.Adapter<NewsHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item_layout,parent,false)
        return NewsHolder(view, onClickOfNews)
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        val articleItemEntity:ArticleItemEntity = newsList[position]
        holder.setNews(articleItemEntity)
    }

    override fun getItemCount(): Int {
       return newsList.size
    }
}

class NewsHolder(val view: View, val onClickOfNews: OnClickOfNews):RecyclerView.ViewHolder(view){

    fun setNews(articleItemEntity: ArticleItemEntity) {
        view.apply {
            //tvNewsNo.text = "${position}."
            tvMostNewsTitle.text = articleItemEntity.title
            tvBookMarkNewsShortDesc.text = articleItemEntity.abstractt
            tvMostUpdatedTime.text = "New York Times"
        }

        view.apply {
            Glide.with(ivBookMarkNewsImg)
                .load(articleItemEntity.image_low)
                .into(ivBookMarkNewsImg)
            ivMostForward.setOnClickListener {
                onClickOfNews.forwardNews(articleItemEntity.url!!, BitMapCreator.ViewShot(view))
            }
            ivMostSave.setOnClickListener {
                Toast.makeText(context,"News Saved Offline", Toast.LENGTH_SHORT).show()
                onClickOfNews.bookmarkNews(articleItemEntity)
            }
        }

        view.apply {
            clMostPopularNews.setOnClickListener {
                onClickOfNews.getNews(articleItemEntity)
            }
        }
    }
}