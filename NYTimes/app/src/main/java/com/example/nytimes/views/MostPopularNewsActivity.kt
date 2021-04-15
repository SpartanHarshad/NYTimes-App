package com.example.nytimes.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nytimes.R
import com.example.nytimes.adapters.MostPopularNewsAdapter
import com.example.nytimes.clickListeners.OnClickOfMostPopularNews
import com.example.nytimes.model.MostPopular
import com.example.nytimes.model.Result
import com.example.nytimes.repository.MostPopularNewsRepo
import com.example.nytimes.viewmodels.MostPopularNewsFactory
import com.example.nytimes.viewmodels.MostPopularNewsviewModel
import kotlinx.android.synthetic.main.activity_most_popular_news.*

class MostPopularNewsActivity : AppCompatActivity(),OnClickOfMostPopularNews {

    lateinit var mostPopularNewsAdapter: MostPopularNewsAdapter
    lateinit var mostPopularNewsviewModel: MostPopularNewsviewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_most_popular_news)
        initViews()
        setRecyclerData()
    }

    private fun initViews() {
        val repo = MostPopularNewsRepo()
        val factory = MostPopularNewsFactory(repo)
        mostPopularNewsviewModel = ViewModelProviders.of(this,factory).get(MostPopularNewsviewModel::class.java)
    }

    private fun setRecyclerData() {
        val results : List<Result> = mostPopularNewsviewModel.getMostPopularNewsModel().results!!
        mostPopularNewsAdapter = MostPopularNewsAdapter(results,this)
        rvMostPopularNews.layoutManager = LinearLayoutManager(this)
        rvMostPopularNews.adapter = mostPopularNewsAdapter
    }

    override fun getMostPopularNews(result: Result) {
        Toast.makeText(this,result.title,Toast.LENGTH_SHORT).show()
    }
}