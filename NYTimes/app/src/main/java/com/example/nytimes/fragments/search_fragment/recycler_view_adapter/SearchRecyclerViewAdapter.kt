package com.example.nytimes.fragments.search_fragment.recycler_view_adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.nytimes.databinding.SearchItemLayoutBinding
import com.example.nytimes.fragments.search_fragment.recycler_view_holder.SearchRecyclerVIewHolder
import com.example.nytimes.local.entity.ArticleItemEntity

class SearchRecyclerViewAdapter :
    PagingDataAdapter<ArticleItemEntity, SearchRecyclerVIewHolder>(diffUtil) {

    override fun onBindViewHolder(holder: SearchRecyclerVIewHolder, position: Int) {
        getItem(position)?.let { holder.setData(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchRecyclerVIewHolder {
        val binding =
            SearchItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return SearchRecyclerVIewHolder(binding)
    }

    companion object {

        val diffUtil = object : DiffUtil.ItemCallback<ArticleItemEntity>() {
            override fun areItemsTheSame(
                oldItem: ArticleItemEntity,
                newItem: ArticleItemEntity
            ): Boolean {
                return newItem == oldItem
            }

            override fun areContentsTheSame(
                oldItem: ArticleItemEntity,
                newItem: ArticleItemEntity
            ): Boolean {
                return oldItem.title == newItem.title
            }
        }
    }
}