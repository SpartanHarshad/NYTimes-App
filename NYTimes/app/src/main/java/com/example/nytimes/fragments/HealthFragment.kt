package com.example.nytimes.fragments

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nytimes.R
import com.example.nytimes.adapters.NewsAdapter
import com.example.nytimes.clickListeners.OnClickOfNews
import com.example.nytimes.local.entity.ArticleItemEntity
import com.example.nytimes.util.Resource
import com.example.nytimes.viewmodels.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_health.*
import kotlinx.android.synthetic.main.fragment_technology.*
import kotlinx.android.synthetic.main.fragment_technology.rvTechnologyNews

@AndroidEntryPoint
class HealthFragment : Fragment(),OnClickOfNews {

    lateinit var newsAdapter: NewsAdapter
    val newsViewModel: NewsViewModel by viewModels()
    var news = mutableListOf<ArticleItemEntity>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_health, container, false)
    }

    companion object {
        fun newInstance(): HealthFragment {
            return HealthFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerData()
        observNews()
        ivBackToSectionsHealth.setOnClickListener {
            launchSections()
        }
    }

    private fun setRecyclerData() {
        newsAdapter = NewsAdapter(news, this)
        rvHealthNews.layoutManager = LinearLayoutManager(context)
        rvHealthNews.adapter = newsAdapter
    }

    private fun observNews() {
        newsViewModel.getNews("Health").observe(viewLifecycleOwner, Observer { result ->
            news.clear()
            news.addAll(result.data!!)
            newsAdapter.notifyDataSetChanged()
            result is Resource.Loading && result.data.isNullOrEmpty()
        })
    }

    private fun launchSections() {
        val action = HealthFragmentDirections.actionHealthFragmentToSectionFragment()
        Navigation.findNavController(requireView()).navigate(action)
    }

    override fun getNews(result: ArticleItemEntity) {
        val action = HealthFragmentDirections.actionHealthFragmentToArticleViewFragment(result.url!!)
        Navigation.findNavController(requireView()).navigate(action)
    }

    override fun forwardNews(url: String, image: Bitmap?) {
        forwardNewsOnSocialMedia(url)
    }

    override fun bookmarkNews(bookmark: ArticleItemEntity) {
        TODO("Not yet implemented")
    }

    fun forwardNewsOnSocialMedia(url: String) {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, url)
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, "Forward")
        startActivity(shareIntent)
    }
}