package com.example.nytimes.fragments

import android.content.Intent
import android.os.Bundle
import android.text.Html
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
import com.example.nytimes.adapters.USNewsAdapter
import com.example.nytimes.adapters.WorldNewsAdapter
import com.example.nytimes.clickListeners.OnClickOfNews
import com.example.nytimes.local.entity.ArticleItemEntity
import com.example.nytimes.util.Resource
import com.example.nytimes.viewmodels.USNewsViewModel
import com.example.nytimes.viewmodels.WorldNewsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_u_s_news.*
import kotlinx.android.synthetic.main.fragment_world_news.*

@AndroidEntryPoint
class USNewsFragment : Fragment(),OnClickOfNews {

    lateinit var usNewsAdapter: USNewsAdapter
    val usNewsViewModel:USNewsViewModel by viewModels();
    var usNews = mutableListOf<ArticleItemEntity>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_u_s_news, container, false)
    }

    companion object {
        fun newInstance(): USNewsFragment {
            return USNewsFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerData()
        observNews()
        ivBackToSection1.setOnClickListener {
            launchSections()
        }
    }

    private fun setRecyclerData() {
        usNewsAdapter = USNewsAdapter(usNews,this)
        rvUSNews.layoutManager = LinearLayoutManager(context)
        rvUSNews.adapter = usNewsAdapter
    }

    private fun observNews() {
        usNewsViewModel.USNewsModel("us").observe(viewLifecycleOwner, Observer{ result ->
            usNews.clear()
            usNews.addAll(result.data!!)
            usNewsAdapter.notifyDataSetChanged()
            Log.d("taggg", "${(result.data?.size ?: 0)}");

            //binding.progressBar.isVisible =
            result is Resource.Loading && result.data.isNullOrEmpty()
            //viewModel.loadingAnimation.postValue(result is Resource.Loading && result.data.isNullOrEmpty())

            //  binding.error.text = result.error?.localizedMessage ?: "yoyo"
        })
    }

    private fun launchSections() {
        val action = USNewsFragmentDirections.actionUSNewsFragmentToSectionFragment()
        Navigation.findNavController(requireView()).navigate(action)
    }

    override fun getNews(result: ArticleItemEntity) {
        val action = USNewsFragmentDirections.actionUSNewsFragmentToArticleViewFragment(result.url!!)
        Navigation.findNavController(requireView()).navigate(action)
    }

    override fun forwardNews(url: String) {
        //Toast.makeText(context,"New Forward $url",Toast.LENGTH_SHORT).show()
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