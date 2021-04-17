package com.example.nytimes.fragments.search_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.androidstudy.networkmanager.Monitor
import com.androidstudy.networkmanager.Tovuti
import com.example.nytimes.clickListeners.RecyclerViewItemClickListener
import com.example.nytimes.databinding.FragmentSearchBinding
import com.example.nytimes.fragments.search_fragment.recycler_view_adapter.SearchRecyclerViewAdapter
import com.example.nytimes.fragments.search_fragment.view_model.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class SearchFragment : Fragment(), RecyclerViewItemClickListener {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SearchViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    private lateinit var newsPagingAdapter: SearchRecyclerViewAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        newsPagingAdapter = SearchRecyclerViewAdapter(this)
        val linearLayout = LinearLayoutManager(context)
        binding.recyclerView.layoutManager = linearLayout
        binding.recyclerView.adapter = newsPagingAdapter

        setNetworkObserver()
        observeConnection()
        setSearchView()
    }

    var searchObserverSet = false
    private fun setSearchView() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {

                viewModel.query.postValue(query)
                if (!searchObserverSet) {
                    setObserver()
                }

                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })
    }

    private fun observeConnection() {
        viewModel.isInternetAvailable.observe(viewLifecycleOwner, Observer {

            if (it) {
                viewModel.query.postValue(viewModel.query.value)
            }

        })
    }

    private fun setNetworkObserver() {
        Tovuti.from(context).monitor(object : Monitor.ConnectivityListener {
            override fun onConnectivityChanged(
                connectionType: Int,
                isConnected: Boolean,
                isFast: Boolean
            ) {
                if (isConnected) {
                    viewModel.isInternetAvailable.postValue(true)
                } else {
                    viewModel.isInternetAvailable.postValue(false)
                }
            }
        })
    }

    private fun setObserver() {
        searchObserverSet = true
        viewModel.news.observe(viewLifecycleOwner, Observer {
            viewLifecycleOwner.lifecycleScope.launch {
                newsPagingAdapter.submitData(it)
            }
        })
    }

    override fun itemClicked(url: String) {
        val action = SearchFragmentDirections.actionSearchFragmentToArticleViewFragment(url)
        Navigation.findNavController(binding.root).navigate(action)
    }


}