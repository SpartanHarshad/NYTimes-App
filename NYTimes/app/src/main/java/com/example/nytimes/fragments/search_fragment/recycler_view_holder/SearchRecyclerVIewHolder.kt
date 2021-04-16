package com.example.nytimes.fragments.search_fragment.recycler_view_holder

import androidx.recyclerview.widget.RecyclerView
import com.example.nytimes.databinding.SearchItemLayoutBinding
import com.example.nytimes.local.entity.ArticleItemEntity

class SearchRecyclerVIewHolder(private val binding: SearchItemLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun setData(news: ArticleItemEntity) {
        binding.textView.text = news.title

    }

}