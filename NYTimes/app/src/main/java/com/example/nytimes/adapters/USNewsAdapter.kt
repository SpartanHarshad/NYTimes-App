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
import kotlinx.android.synthetic.main.news_item_layout.view.*

class USNewsAdapter(val neswList:List<ArticleItemEntity>, val onClickOfNews: OnClickOfNews):RecyclerView.Adapter<USNewsHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): USNewsHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item_layout,parent,false)
        return USNewsHolder(view,onClickOfNews)
    }

    override fun onBindViewHolder(holder: USNewsHolder, position: Int) {
        val articleItemEntity: ArticleItemEntity = neswList[position]
        holder.setNews(articleItemEntity)
    }

    override fun getItemCount(): Int {
        return neswList.size
    }
}

class USNewsHolder(val view: View, val onClickOfNews: OnClickOfNews):RecyclerView.ViewHolder(view){

    fun setNews(articleItemEntity: ArticleItemEntity) {
        view.apply {
            //tvNewsNo.text = "${position}."
            tvMostNewsTitle.text = articleItemEntity.title
            tvMostNewsShortDesc.text = articleItemEntity.abstractt
            tvMostUpdatedTime.text = articleItemEntity.updated_date
        }
        view.apply {
            Glide.with(ivMostNewsImg)
                .load(articleItemEntity.image_low)
                .into(ivMostNewsImg)
            ivMostForward.setOnClickListener {
                onClickOfNews.forwardNews(articleItemEntity.url!!)
            }
            ivMostSave.setOnClickListener {
                // onClickOfNews.getNews(articleItemEntity)
                Toast.makeText(context,"News Saved Offline", Toast.LENGTH_SHORT).show()
            }
        }
        view.apply {
            clMostPopularNews.setOnClickListener {
                onClickOfNews.getNews(articleItemEntity)
            }
        }
    }
}