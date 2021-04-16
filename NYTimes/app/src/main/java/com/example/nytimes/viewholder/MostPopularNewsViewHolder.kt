package com.example.nytimes.viewholder

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nytimes.clickListeners.OnClickOfNews
import com.example.nytimes.local.entity.ArticleItemEntity
import kotlinx.android.synthetic.main.news_item_layout.view.*

class MostPopularNewsViewHolder(val view: View, val onClickOfMostPopularNews: OnClickOfNews
) : RecyclerView.ViewHolder(view) {

    fun setMostPopularNews(result: ArticleItemEntity, position:Int) {
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
                onClickOfMostPopularNews.forwardNews(result.url!!)
            }
            ivMostSave.setOnClickListener {
                //onClickOfMostPopularNews.getMostPopularNews(result)
                Toast.makeText(context,"News Saved Offline", Toast.LENGTH_SHORT).show()
            }
        }

        view.apply {
            clMostPopularNews.setOnClickListener {
                onClickOfMostPopularNews.getNews(result)
            }
        }
    }
}