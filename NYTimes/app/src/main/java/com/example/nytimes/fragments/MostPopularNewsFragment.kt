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
import com.example.nytimes.clickListeners.OnClickOfNews
import com.example.nytimes.model.Result
import com.example.nytimes.repository.MostPopularNewsRepo
import com.example.nytimes.viewmodels.MostPopularNewsFactory
import com.example.nytimes.viewmodels.MostPopularNewsviewModel
import kotlinx.android.synthetic.main.activity_most_popular_news.*

class MostPopularNewsFragment : Fragment(), OnClickOfNews {

    lateinit var mostPopularNewsAdapter: MostPopularNewsAdapter
    lateinit var mostPopularNewsviewModel: MostPopularNewsviewModel
    var results = mutableListOf<Result>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_most_popular_news, container, false)
    }

    companion object {
        fun newInstance(): MostPopularNewsFragment {
            return MostPopularNewsFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val repo = MostPopularNewsRepo()
        val factory = MostPopularNewsFactory(repo)
        mostPopularNewsviewModel =
            ViewModelProviders.of(this, factory).get(MostPopularNewsviewModel::class.java)
        setRecyclerData()
        observNews()
        ivBackToSections.setOnClickListener {
            launchSections()
        }
    }

    private fun setRecyclerData() {
        mostPopularNewsAdapter = MostPopularNewsAdapter(results, this)
        rvMostPopularNews.layoutManager = LinearLayoutManager(context)
        rvMostPopularNews.adapter = mostPopularNewsAdapter
    }

    private fun observNews() {
        mostPopularNewsviewModel.mostPopularNewsModel().observe(viewLifecycleOwner, Observer {
            results.clear()
            results.addAll(it)
            mostPopularNewsAdapter.notifyDataSetChanged()
        })
    }

    private fun launchSections() {
        val fragmentTransaction = fragmentManager?.beginTransaction()
        val sectionFragment = SectionFragment()
        fragmentTransaction?.replace(R.id.newsNavHostFragment, sectionFragment, "sectionFragment")?.addToBackStack("sectionFragment")?.commit()
    }

    override fun getMostPopularNews(result: Result) {
        Toast.makeText(context, result.title, Toast.LENGTH_SHORT).show()
    }
}