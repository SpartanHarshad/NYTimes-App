package com.example.nytimes.fragments.search_fragment.recycler_view_holder

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nytimes.clickListeners.RecyclerViewItemClickListener
import com.example.nytimes.databinding.SearchItemLayoutBinding
import com.example.nytimes.local.entity.ArticleItemEntity

class SearchRecyclerVIewHolder(
    private val binding: SearchItemLayoutBinding,
    private val clickListener: RecyclerViewItemClickListener
) :
    RecyclerView.ViewHolder(binding.root) {

    fun setData(news: ArticleItemEntity) {
        binding.textView.text = news.title
        if (!news.image_high.equals("nan")) {
            Glide.with(binding.root).load(news.image_high).into(binding.imageView2)
        }

        binding.layout.setOnClickListener {

            news.url?.let { it1 -> clickListener.itemClicked(it1) }

        }

    }

}