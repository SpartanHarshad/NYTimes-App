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
import com.example.nytimes.adapters.PoliticsNewAdapter
import com.example.nytimes.adapters.USNewsAdapter
import com.example.nytimes.clickListeners.OnClickOfNews
import com.example.nytimes.local.entity.ArticleItemEntity
import com.example.nytimes.util.Resource
import com.example.nytimes.viewmodels.PoliticsViewModel
import com.example.nytimes.viewmodels.USNewsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_politics_news.*
import kotlinx.android.synthetic.main.fragment_u_s_news.*

@AndroidEntryPoint
class PoliticsNewsFragment : Fragment(), OnClickOfNews {

    val politicsViewModel: PoliticsViewModel by viewModels()
    var politicsNews = mutableListOf<ArticleItemEntity>()
    lateinit var politicNewAdapter: PoliticsNewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_politics_news, container, false)
    }

    companion object {
        fun newInstance(): PoliticsNewsFragment {
            return PoliticsNewsFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerData()
        observNews()
        ivBackToSection2.setOnClickListener {
            launchSections()
        }
    }

    private fun setRecyclerData() {
        politicNewAdapter = PoliticsNewAdapter(politicsNews,this)
        rvPoliticsNews.layoutManager = LinearLayoutManager(context)
        rvPoliticsNews.adapter = politicNewAdapter
    }

    private fun observNews() {
        politicsViewModel.polNewsModel("politics").observe(viewLifecycleOwner, Observer {result->
            politicsNews.clear()
            politicsNews.addAll(result.data!!)
            //Log.d("politics", "observNews: ${result.data!!}")
            politicNewAdapter.notifyDataSetChanged()
            result is Resource.Loading && result.data.isNullOrEmpty()
        })
    }

    private fun launchSections() {
        val action = PoliticsNewsFragmentDirections.actionPoliticsNewsFragmentToSectionFragment()
        Navigation.findNavController(requireView()).navigate(action)
    }

    override fun getNews(result: ArticleItemEntity) {
        val action =
            PoliticsNewsFragmentDirections.actionPoliticsNewsFragmentToArticleViewFragment(result.url!!)
        Navigation.findNavController(requireView()).navigate(action)
    }

    override fun forwardNews(url: String) {
        forwardNewsOnSocialMedia(url)
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