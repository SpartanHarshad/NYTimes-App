package com.example.nytimes.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nytimes.R
import com.example.nytimes.clickListeners.OnClickOfMostPopularNews
import com.example.nytimes.model.Result
import kotlinx.android.synthetic.main.mostpopular_news_item_layout.view.*

class MostPopularNewsAdapter(val mostPopularNewsList: List<Result>, val onClickOfMostPopularNews: OnClickOfMostPopularNews
) : RecyclerView.Adapter<MostPopularNewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MostPopularNewsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.mostpopular_news_item_layout, parent, false)
        return MostPopularNewsViewHolder(view, onClickOfMostPopularNews)
    }

    override fun onBindViewHolder(holder: MostPopularNewsViewHolder, position: Int) {
        val result: Result = mostPopularNewsList[position]
        holder.setMostPopularNews(result)
    }

    override fun getItemCount(): Int {
        return mostPopularNewsList.size
    }
}

class MostPopularNewsViewHolder(val view: View, val onClickOfMostPopularNews: OnClickOfMostPopularNews
) : RecyclerView.ViewHolder(view) {

    fun setMostPopularNews(result: Result) {
        view.apply {
            tvNewsNo.text = result.assetId.toString()
            tvMostNewsTitle.text = result.title
            tvMostNewsShortDesc.text = result.abstract
            tvMostUpdatedTime.text = result.updated
        }
        view.apply {
            Glide.with(ivMostNewsImg)
                .load(result!!.media!![0].mediaMetadata!![0].url)
                .into(ivMostNewsImg)
            ivMostForward.setOnClickListener {
                onClickOfMostPopularNews.getMostPopularNews(result)
            }
            ivMostSave.setOnClickListener {
                onClickOfMostPopularNews.getMostPopularNews(result)
            }
        }
        view.apply {
            clMostPopularNews.setOnClickListener {
                onClickOfMostPopularNews.getMostPopularNews(result)
            }
        }
    }
}