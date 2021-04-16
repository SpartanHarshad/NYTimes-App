package com.example.nytimes.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nytimes.R
import com.example.nytimes.adapters.WorldNewsAdapter
import com.example.nytimes.clickListeners.OnClickOfNews
import com.example.nytimes.local.entity.ArticleItemEntity
import com.example.nytimes.util.Resource
import com.example.nytimes.viewmodels.WorldNewsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_world_news.*

@AndroidEntryPoint
class WorldNewsFragment : Fragment(),OnClickOfNews {

    lateinit var worldNewsAdapter: WorldNewsAdapter
    val worldNewsViewModel: WorldNewsViewModel by viewModels();
    var worldnews = mutableListOf<ArticleItemEntity>()

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
        worldNewsViewModel.worldNewsModel("world").observe(viewLifecycleOwner, Observer{ result ->
            worldnews.clear()
            worldnews.addAll(result.data!!)
            worldNewsAdapter.notifyDataSetChanged()
            Log.d("taggg", "${(result.data?.size ?: 0)}");

            //binding.progressBar.isVisible =
            result is Resource.Loading && result.data.isNullOrEmpty()
            //viewModel.loadingAnimation.postValue(result is Resource.Loading && result.data.isNullOrEmpty())

            //  binding.error.text = result.error?.localizedMessage ?: "yoyo"
        })
    }

    private fun launchSections() {
       // val action = WorldNewsFragmentDirections.actionWorldNewsFragmentToSectionFragment2()
        //Navigation.findNavController(requireView()).navigate(action)
    }

    override fun getNews(result: ArticleItemEntity) {
       // val action = WorldNewsFragmentDirections.actionWorldNewsFragmentToArticleViewFragment2(result.url!!)
       //  Navigation.findNavController(requireView()).navigate(action)
    }

    override fun forwardNews(url: String) {
        forwardNewsOnSocialMedia(url)
    }

    fun forwardNewsOnSocialMedia(url:String){
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, url)
            type = "text/plain"
        }
        val shareIntent = Intent.createChooser(sendIntent, "Forward")
        startActivity(shareIntent)
    }
}