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

class MostPopularNewAdapter(
    val mostPopularNewsList: List<ArticleItemEntity>, val onClickOfMostPopularNews: OnClickOfNews
) : RecyclerView.Adapter<MostPopularNewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MostPopularNewsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.news_item_layout, parent, false)
        return MostPopularNewsViewHolder(view, onClickOfMostPopularNews)
    }

    override fun onBindViewHolder(holder: MostPopularNewsViewHolder, position: Int) {
        val result: ArticleItemEntity = mostPopularNewsList[position]
        holder.setMostPopularNews(result, position)
    }

    override fun getItemCount(): Int {
        return mostPopularNewsList.size
    }
}

class MostPopularNewsViewHolder(
    val view: View, val onClickOfMostPopularNews: OnClickOfNews
) : RecyclerView.ViewHolder(view) {

    fun setMostPopularNews(result: ArticleItemEntity, position: Int) {
        view.apply {
            tvNewsNo.text = "${position}."
            tvMostNewsTitle.text = result.title
            tvMostNewsShortDesc.text = result.abstractt
            tvMostUpdatedTime.text = result.updated_date
        }
        view.apply {
            Glide.with(ivMostNewsImg)
                .load(result.image_low)
                .into(ivMostNewsImg)
            ivMostForward.setOnClickListener {


                onClickOfMostPopularNews.forwardNews(result.url!!, BitMapCreator.ViewShot(view))
            }
            ivMostSave.setOnClickListener {
                Toast.makeText(context, "News Saved Offline", Toast.LENGTH_SHORT).show()
            }
        }

        view.apply {
            clMostPopularNews.setOnClickListener {
                onClickOfMostPopularNews.getNews(result)
            }
        }
    }
}
