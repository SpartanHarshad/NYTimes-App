package com.example.nytimes.fragments

import android.content.Intent
import android.graphics.Bitmap
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
import androidx.work.*
import com.example.nytimes.R
import com.example.nytimes.adapters.NewsAdapter
import com.example.nytimes.clickListeners.OnClickOfNews
import com.example.nytimes.local.entity.ArticleItemEntity
import com.example.nytimes.local.entity_to_dto.CreateBookmarkDto
import com.example.nytimes.util.Resource
import com.example.nytimes.viewmodels.NewsViewModel
import com.example.nytimes.worker.BOOKMARK_INSERT
import com.example.nytimes.worker.BookmarkWork
import com.google.firebase.auth.FirebaseAuth
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_business_news.*
import kotlinx.android.synthetic.main.fragment_sports.*

@AndroidEntryPoint
class SportsFragment : Fragment(), OnClickOfNews {

    lateinit var newsAdapter: NewsAdapter
    val newsViewModel: NewsViewModel by viewModels()
    var news = mutableListOf<ArticleItemEntity>()
    lateinit var User_Mail: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val firebaseAuth = FirebaseAuth.getInstance()
        val user = firebaseAuth.getCurrentUser()
        User_Mail = user!!.getEmail()!!
        Log.d("Email", "onCreate: $User_Mail")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_sports, container, false)
    }

    companion object {
        fun newInstance(): SportsFragment {
            return SportsFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerData()
        observNews()
        ivBackToSectionSport.setOnClickListener {
            launchSections()
        }
    }

    private fun setRecyclerData() {
        newsAdapter = NewsAdapter(news,this)
        rvSportsNews.layoutManager = LinearLayoutManager(context)
        rvSportsNews.adapter = newsAdapter
    }

    private fun observNews() {
        newsViewModel.getNews("Sports").observe(viewLifecycleOwner, Observer{ result ->
            news.clear()
            news.addAll(result.data!!)
            newsAdapter.notifyDataSetChanged()
            result is Resource.Loading && result.data.isNullOrEmpty()
        })
    }

    private fun launchSections() {
        val action = SportsFragmentDirections.actionSportsFragmentToSectionFragment()
        Navigation.findNavController(requireView()).navigate(action)
    }

    override fun getNews(result: ArticleItemEntity) {
        val action = SportsFragmentDirections.actionSportsFragmentToArticleViewFragment(result.url!!)
        Navigation.findNavController(requireView()).navigate(action)
    }

    override fun forwardNews(url: String, image: Bitmap?) {
        forwardNewsOnSocialMedia(url)
    }

    override fun bookmarkNews(bookmark: ArticleItemEntity) {
        val data = CreateBookmarkDto.createBookmark(bookmark, User_Mail)
        val gson = Gson()
        val jsonBookmark = gson.toJson(data)

        val constraints = Constraints.Builder()
        constraints.setRequiredNetworkType(NetworkType.CONNECTED)
        constraints.setRequiresCharging(false)

        val inputData = Data.Builder()
        inputData.putString("data", jsonBookmark)
        inputData.putInt("type", BOOKMARK_INSERT)

        val work = OneTimeWorkRequest.Builder(BookmarkWork::class.java)
        work.setConstraints(constraints.build())
        work.setInputData(inputData.build())
        work.addTag("book mark")

        val workManager = context?.let { WorkManager.getInstance(it) }

        workManager?.enqueue(work.build())
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