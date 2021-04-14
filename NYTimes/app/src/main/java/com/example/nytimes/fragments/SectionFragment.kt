package com.example.nytimes.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nytimes.R
import com.example.nytimes.adapters.SectionAdapter
import com.example.nytimes.clickListeners.SectionOnClickListener
import com.example.nytimes.model.Sections
import com.example.nytimes.repository.SectionRepository
import com.example.nytimes.viewmodels.AllSectionsViewModel
import com.example.nytimes.viewmodels.AllSectionsViewModelFactory
import com.example.nytimes.views.MostPopularNewsActivity
import kotlinx.android.synthetic.main.fragment_section.*


class SectionFragment : Fragment(), SectionOnClickListener {

    lateinit var sectionAdapter: SectionAdapter
    lateinit var sectionsViewModel: AllSectionsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_section, container, false)
    }

    companion object {
        fun newInstance(): SectionFragment {
            return SectionFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val repo = SectionRepository()
        val viewmodelFactory = AllSectionsViewModelFactory(repo)
        sectionsViewModel =
            ViewModelProviders.of(this, viewmodelFactory).get(AllSectionsViewModel::class.java)
        setRecyclerData()
    }

    private fun setRecyclerData() {
        var list = sectionsViewModel.allSectionsModel()
        sectionAdapter = SectionAdapter(list, this)
        rvSection.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rvSection.adapter = sectionAdapter
    }

    override fun getSectionName(sections: Sections) {
        var sectionName = sections.name

        when(sectionName){
            "Most Popular" ->{
                val intent = Intent(context,MostPopularNewsActivity::class.java)
                startActivity(intent)
            }
        }
        Toast.makeText(context, "${sections.icon} Section Clicked", Toast.LENGTH_SHORT).show()
    }
}