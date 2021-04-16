package com.example.nytimes.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nytimes.R
import com.example.nytimes.api.Resource
import com.example.nytimes.viewmodels.ForYouViewModel
import com.example.nytimes.views.ForYouAdapter
import com.example.nytimes.views.MainActivity
import kotlinx.android.synthetic.main.fragment_foryou.*


class ForYouFragment:Fragment(R.layout.fragment_foryou) {

    lateinit var viewModel: ForYouViewModel
    lateinit var newsAdapter: ForYouAdapter

    val TAG = "ForYouFragment"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
        setupRecyclerView()

        newsAdapter.setOnItemClickListener {
            val bundle=Bundle().apply {
                putSerializable("article", it)
            }
            findNavController().navigate(
                    R.id.action_forYouFragment_to_articleFragment2,bundle
            )
        }

        viewModel.foryouNews.observe(viewLifecycleOwner, Observer { response ->
            when(response) {
                is Resource.Success -> {
                    hideProgressBar()
                    response.data?.let { newsResponse ->
                        newsAdapter.differ.submitList(newsResponse.articles)
                    }
                }
                is Resource.Error -> {
                    hideProgressBar()
                    response.message?.let { message ->
                        Log.e(TAG, "An error occured: $message")
                    }
                }
                is Resource.Loading -> {
                    showProgressBar()
                }
            }
        })
    }

    private fun hideProgressBar() {
        paginationProgressBar.visibility = View.INVISIBLE
    }

    private fun showProgressBar() {
        paginationProgressBar.visibility = View.VISIBLE
    }

    private fun setupRecyclerView() {
        newsAdapter = ForYouAdapter()
        ForyouNews.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }
}