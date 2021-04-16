package com.example.nytimes.fragments.search_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.ExperimentalPagingApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nytimes.databinding.FragmentSearchBinding
import com.example.nytimes.fragments.search_fragment.recycler_view_adapter.SearchRecyclerViewAdapter
import com.example.nytimes.fragments.search_fragment.view_model.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@AndroidEntryPoint
class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    val viewModel: SearchViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    @ExperimentalPagingApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val newsPagingAdapter = SearchRecyclerViewAdapter()


        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.pager.collectLatest {
                newsPagingAdapter.submitData(it)
            }
        }
        val linearLayout = LinearLayoutManager(context)
        binding.recyclerView.layoutManager = linearLayout
        binding.recyclerView.adapter = newsPagingAdapter
    }


}