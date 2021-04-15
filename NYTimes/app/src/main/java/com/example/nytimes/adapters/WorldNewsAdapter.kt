package com.example.nytimes.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nytimes.R
import com.example.nytimes.clickListeners.OnClickOfWorldNews
import com.example.nytimes.model.worldnews.Doc
import kotlinx.android.synthetic.main.mostpopular_news_item_layout.view.*

class WorldNewsAdapter(val neswList:List<Doc>,val onClickOfWorldNews: OnClickOfWorldNews):RecyclerView.Adapter<WorldNewsHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorldNewsHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.mostpopular_news_item_layout,parent,false)
        return WorldNewsHolder(view,onClickOfWorldNews)
    }

    override fun onBindViewHolder(holder: WorldNewsHolder, position: Int) {
        val doc:Doc = neswList[position]
        holder.setNews(doc)
    }

    override fun getItemCount(): Int {
        return neswList.size
    }
}

class WorldNewsHolder(val view: View, val onClickOfNews: OnClickOfWorldNews):RecyclerView.ViewHolder(view){

    fun setNews(doc: Doc) {
        view.apply {
            //tvNewsNo.text = "${position}."
            tvMostNewsTitle.text = doc.headline!!.main
            tvMostNewsShortDesc.text = doc.abstract
            tvMostUpdatedTime.text = doc.source
        }
        view.apply {
            Glide.with(ivMostNewsImg)
                .load(doc!!.multimedia!![0].url!!)
                .into(ivMostNewsImg)
            ivMostForward.setOnClickListener {
                onClickOfNews.getWorldNews(doc)
            }
            ivMostSave.setOnClickListener {
                //onClickOfMostPopularNews.getMostPopularNews(result)
                Toast.makeText(context,"News Saved Offline", Toast.LENGTH_SHORT).show()
            }
        }
        view.apply {
            clMostPopularNews.setOnClickListener {
                onClickOfNews.getWorldNews(doc)
            }
        }
    }
}