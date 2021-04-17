package com.example.nytimes.fragments.today_fragment.recycler_view_holder

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nytimes.clickListeners.RecyclerViewItemClickListener
import com.example.nytimes.databinding.TodayNewsItemBinding
import com.example.nytimes.local.entity.ArticleItemEntity

class TodayRecyclerViewHolder(
    var binding: TodayNewsItemBinding,
    val clickListener: RecyclerViewItemClickListener
) :
    RecyclerView.ViewHolder(binding.root) {

    public fun setData(article: ArticleItemEntity) {

        binding.tvHeading.text = article.title
        binding.tvDescription.text = article.abstractt
        binding.tvByLine.text = article.byline
        Glide.with(binding.root).load(article.image_high).into(binding.imageView)

        binding.layout.setOnClickListener {
            article.url?.let { it1 -> clickListener.itemClicked(it1) }
        }

    }
}