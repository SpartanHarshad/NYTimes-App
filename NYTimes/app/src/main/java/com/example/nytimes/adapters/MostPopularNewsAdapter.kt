package com.example.nytimes.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nytimes.R
import com.example.nytimes.clickListeners.OnClickOfNews
import com.example.nytimes.model.Result
import kotlinx.android.synthetic.main.mostpopular_news_item_layout.view.*

class MostPopularNewsAdapter(val mostPopularNewsList: List<Result>, val onClickOfMostPopularNews: OnClickOfNews
) : RecyclerView.Adapter<MostPopularNewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MostPopularNewsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.mostpopular_news_item_layout, parent, false)
        return MostPopularNewsViewHolder(view, onClickOfMostPopularNews)
    }

    override fun onBindViewHolder(holder: MostPopularNewsViewHolder, position: Int) {
        val result: Result = mostPopularNewsList[position]
        holder.setMostPopularNews(result,position)
    }

    override fun getItemCount(): Int {
        return mostPopularNewsList.size
    }
}

class MostPopularNewsViewHolder(val view: View, val onClickOfMostPopularNews: OnClickOfNews
) : RecyclerView.ViewHolder(view) {

    fun setMostPopularNews(result: Result,position:Int) {
        view.apply {
            tvNewsNo.text = "${position}."
            tvMostNewsTitle.text = result.title
            tvMostNewsShortDesc.text = result.abstract
            tvMostUpdatedTime.text = result.source
        }
        view.apply {
            Glide.with(ivMostNewsImg)
                .load(result!!.media!![0].mediaMetadata!![0].url)
                .into(ivMostNewsImg)
            ivMostForward.setOnClickListener {
                onClickOfMostPopularNews.getMostPopularNews(result)
            }
            ivMostSave.setOnClickListener {
                //onClickOfMostPopularNews.getMostPopularNews(result)
                Toast.makeText(context,"News Saved Offline",Toast.LENGTH_SHORT).show()
            }
        }
        view.apply {
            clMostPopularNews.setOnClickListener {
                onClickOfMostPopularNews.getMostPopularNews(result)
            }
        }
    }
}