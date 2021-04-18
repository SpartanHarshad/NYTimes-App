package com.example.nytimes.fragments

import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.nytimes.R
import com.example.nytimes.local.ForYouDatabase
import com.example.nytimes.repository.YouRepository
import com.example.nytimes.viewmodels.ForViewModelProviderFactory
import com.example.nytimes.viewmodels.ForYouViewModel
import com.example.nytimes.views.MainActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_article.*

class ArticleFragment : Fragment(R.layout.fragment_article) {

    lateinit var viewModel: ForYouViewModel
    val args: ArticleFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val youRepository = YouRepository(ForYouDatabase(requireContext()))
        val viewModelProviderFactory = ForViewModelProviderFactory(youRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(ForYouViewModel::class.java)
        //(activity as MainActivity).viewModel
        val article = args.article
        webView.apply {
            webViewClient = WebViewClient()
            loadUrl(article.url)
        }

        fab.setOnClickListener {
            viewModel.saveArticle(article)
            Snackbar.make(view, "Article saved", Snackbar.LENGTH_SHORT).show()
        }
    }
}
