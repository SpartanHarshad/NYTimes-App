package com.example.nytimes.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nytimes.R
import com.example.nytimes.clickListeners.OnClickListener
import com.example.nytimes.model.Sections
import kotlinx.android.synthetic.main.section_items.view.*

class SectionAdapter(
    val sectionList: List<Sections>, val sectionOnClickListener: OnClickListener
) : RecyclerView.Adapter<SectionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SectionViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.section_items, parent, false)
        return SectionViewHolder(view, sectionOnClickListener)
    }

    override fun onBindViewHolder(holder: SectionViewHolder, position: Int) {
        val sections: Sections = sectionList[position]
        holder.setSections(sections)
    }

    override fun getItemCount(): Int {
        return sectionList.size
    }
}

class SectionViewHolder(val view: View, val sectionOnClickListener: OnClickListener) :
    RecyclerView.ViewHolder(view) {

    fun setSections(sections: Sections) {
        view.apply {
            ivIcon.setImageResource(sections.icon)
        }
        view.apply {
            TvSectionName.text = sections.name;
        }
        view.apply {
            rlSection.setOnClickListener {
                sectionOnClickListener.getSectionName(sections)
            }
        }
    }
}