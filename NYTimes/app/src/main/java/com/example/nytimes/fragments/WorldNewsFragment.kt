package com.example.nytimes.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nytimes.R
import com.example.nytimes.adapters.MostPopularNewsAdapter
import com.example.nytimes.adapters.WorldNewsAdapter
import com.example.nytimes.clickListeners.OnClickOfWorldNews
import com.example.nytimes.model.Result
import com.example.nytimes.model.worldnews.Doc
import com.example.nytimes.repository.MostPopularNewsRepo
import com.example.nytimes.repository.WorldNewsRepo
import com.example.nytimes.viewmodels.MostPopularNewsFactory
import com.example.nytimes.viewmodels.MostPopularNewsviewModel
import com.example.nytimes.viewmodels.WorldNewsFactory
import com.example.nytimes.viewmodels.WorldNewsViewModel
import kotlinx.android.synthetic.main.activity_most_popular_news.*
import kotlinx.android.synthetic.main.fragment_world_news.*


class WorldNewsFragment : Fragment(),OnClickOfWorldNews {

    lateinit var worldNewsAdapter: WorldNewsAdapter
    lateinit var worldNewsViewModel: WorldNewsViewModel
    var worldnews = mutableListOf<Doc>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_world_news, container, false)
    }

    companion object {
        fun newInstance(): MostPopularNewsFragment {
            return MostPopularNewsFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val repo = WorldNewsRepo()
        val factory = WorldNewsFactory(repo)
        worldNewsViewModel = ViewModelProviders.of(this, factory).get(WorldNewsViewModel::class.java)
        setRecyclerData()
        observNews()
        ivBackToSection.setOnClickListener {
            launchSections()
        }
    }

    private fun setRecyclerData() {
        worldNewsAdapter = WorldNewsAdapter(worldnews,this)
        rvWorldNews.layoutManager = LinearLayoutManager(context)
        rvWorldNews.adapter = worldNewsAdapter
    }

    private fun observNews() {
        worldNewsViewModel.worldNewsModel().observe(viewLifecycleOwner, Observer {
            worldnews.clear()
            worldnews.addAll(it)
            worldNewsAdapter.notifyDataSetChanged()
        })
    }

    private fun launchSections() {
        val fragmentTransaction = fragmentManager?.beginTransaction()
        val sectionFragment = SectionFragment()
        fragmentTransaction?.replace(R.id.newsNavHostFragment, sectionFragment, "sectionFragment")?.addToBackStack("sectionFragment")?.commit()
    }

    override fun getWorldNews(doc: Doc) {
        Toast.makeText(context, doc.leadParagraph, Toast.LENGTH_SHORT).show()
    }
}