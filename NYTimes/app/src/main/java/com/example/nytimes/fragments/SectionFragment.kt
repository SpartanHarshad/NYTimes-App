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
        var sectionName = sections.icon.toString()

        when (sectionName) {
            "2131165308" -> {
                launchMostPopular()
            }
            "2131165329" -> {
                launchWorld()
            }
            "2131165325" -> {
                //launchUS()
            }
            "2131165317" -> {
                //launchPolitics()
            }
            "2131165296" -> {
                //launchBusiness()
            }
            "2131165320" -> {
                //launchSports()
            }
            "2131165292" -> {
                //launchArts()
            }
            "2131165315" -> {
                //launchMagazine()
            }
        }
        Toast.makeText(context, "${sections.icon} Section Clicked", Toast.LENGTH_SHORT).show()
    }

    private fun launchMostPopular() {
        val fragmentTransaction = fragmentManager?.beginTransaction()
        val mostPopularNewsFragment = MostPopularNewsFragment()
        fragmentTransaction?.replace(
            R.id.newsNavHostFragment, mostPopularNewsFragment, "mostPopularNewsFragment"
        )?.addToBackStack("mostPopularNewsFragment")?.commit()
    }

    private fun launchWorld() {
        val fragmentTransaction = fragmentManager?.beginTransaction()
        val worldNewsFragment = WorldNewsFragment()
        fragmentTransaction?.replace(R.id.newsNavHostFragment, worldNewsFragment, "worldNewsFragment"
        )?.addToBackStack("worldNewsFragment")?.commit()
    }
}