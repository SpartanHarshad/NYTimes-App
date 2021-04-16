package com.example.nytimes.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nytimes.R
import com.example.nytimes.adapters.MostPopularNewAdapter
import com.example.nytimes.clickListeners.OnClickOfNews
import com.example.nytimes.local.entity.ArticleItemEntity
import com.example.nytimes.util.Resource
import com.example.nytimes.viewmodels.MostPopularNewsviewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_most_popular_news.*

@AndroidEntryPoint
class MostPopularNewsFragment : Fragment(), OnClickOfNews {

    lateinit var mostPopularNewsAdapter: MostPopularNewAdapter
     val mostPopularNewsviewModel: MostPopularNewsviewModel by viewModels();
    var results = mutableListOf<ArticleItemEntity>()

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
        setRecyclerData()
        observNews()
        ivBackToSections.setOnClickListener {
            launchSections()
        }
    }

    private fun setRecyclerData() {
        mostPopularNewsAdapter = MostPopularNewAdapter(results, this)
        rvMostPopularNews.layoutManager = LinearLayoutManager(context)
        rvMostPopularNews.adapter = mostPopularNewsAdapter
    }

    private fun observNews() {
        mostPopularNewsviewModel.getNews("mostpopular").observe(viewLifecycleOwner, Observer { result ->
            results.clear()
            results.addAll(result.data!!)
            mostPopularNewsAdapter.notifyDataSetChanged()
            Log.d("taggg", "${(result.data?.size ?: 0)}");

            //binding.progressBar.isVisible =
                result is Resource.Loading && result.data.isNullOrEmpty()
            //viewModel.loadingAnimation.postValue(result is Resource.Loading && result.data.isNullOrEmpty())

            //  binding.error.text = result.error?.localizedMessage ?: "yoyo"

        })
    }

    private fun launchSections() {
        val action = MostPopularNewsFragmentDirections.actionMostPopularNewsFragmentToSectionFragment()
        Navigation.findNavController(requireView()).navigate(action)
    }

    override fun getNews(result: ArticleItemEntity) {
        val action = MostPopularNewsFragmentDirections.actionMostPopularNewsFragmentToArticleViewFragment(result.url!!)
        Navigation.findNavController(requireView()).navigate(action)
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