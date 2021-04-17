package com.example.nytimes.fragments

import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.nytimes.R
import com.example.nytimes.viewmodels.ForYouViewModel
import com.example.nytimes.views.MainActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_article.*

class ArticleFragment : Fragment(R.layout.fragment_article) {
    lateinit var viewModel: ForYouViewModel
//    lateinit var forYouAdapter: ForYouAdapter
    // val foryouNews: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()

    val args: ArticleFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
        val article = args.article
        webView.apply {
            webViewClient = WebViewClient()
            loadUrl(article.url)
        }

        fab.setOnClickListener {
            viewModel.saveArticle(article)
            Snackbar.make(view, "Article saved", Snackbar.LENGTH_SHORT).show()
        }

        // viewModel.getSavedNews().observe(viewLifecycleOwner, Observer { article->
//            forYouAdapter.differ.submitList(article)
        // })

    }

}
