package com.example.nytimes.fragments.today_fragment.recycler_view_adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nytimes.clickListeners.RecyclerViewItemClickListener
import com.example.nytimes.databinding.TodayNewsItemBinding
import com.example.nytimes.fragments.today_fragment.recycler_view_holder.TodayRecyclerViewHolder
import com.example.nytimes.local.entity.ArticleItemEntity

class TodayRecyclerViewAdapter(
    var list: List<ArticleItemEntity>?,
    private val clickListener: RecyclerViewItemClickListener
) :
    RecyclerView.Adapter<TodayRecyclerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodayRecyclerViewHolder {

        val binding =
            TodayNewsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false);
        return TodayRecyclerViewHolder(binding,clickListener)
    }

    override fun onBindViewHolder(holder: TodayRecyclerViewHolder, position: Int) {
        list?.get(position)?.let { holder.setData(it) }
    }

    override fun getItemCount(): Int {

        if (list != null) {
            return list!!.size
        }
        return 0
    }

    fun updateList(data: List<ArticleItemEntity>?) {
        list = data
        notifyDataSetChanged()
    }
}