package com.example.nytimes.fragments.today_fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.androidstudy.networkmanager.Monitor
import com.androidstudy.networkmanager.Tovuti
import com.example.nytimes.R
import com.example.nytimes.clickListeners.RecyclerViewItemClickListener
import com.example.nytimes.databinding.FragmentTodayBinding
import com.example.nytimes.fragments.today_fragment.recycler_view_adapter.TodayRecyclerViewAdapter
import com.example.nytimes.util.Resource
import com.example.nytimes.viewmodels.TodayViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class TodayFragment : Fragment(R.layout.fragment_today), RecyclerViewItemClickListener {

    private var _binding: FragmentTodayBinding? = null
    private val binding get() = _binding!!

    val viewModel: TodayViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTodayBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView()
        setNetworkObserver()
        setObserver()
        setSwipeListener()

    }

    var startNetworkCheck = false;
    private fun setNetworkObserver() {
        Tovuti.from(context).monitor(object : Monitor.ConnectivityListener {
            override fun onConnectivityChanged(
                connectionType: Int,
                isConnected: Boolean,
                isFast: Boolean
            ) {
                if (isConnected && startNetworkCheck) {
                    Log.d("taggg", "network is back")
                    viewModel.loadingAnimation.postValue(true)
                    setObserver()
                } else {
                    Snackbar.make(
                        binding.root,
                        "No Internet",
                        Snackbar.LENGTH_SHORT
                    )
                        .show()
                }
            }
        })
    }

    private fun setSwipeListener() {

        viewModel.loadingAnimation.observe(viewLifecycleOwner, Observer {
            binding.swipeRefreshLayout.isRefreshing = it
        })

        binding.swipeRefreshLayout.setOnRefreshListener {
            viewModel.loadingAnimation.postValue(true)
            setObserver()
        }
    }

    private lateinit var todayAdapter: TodayRecyclerViewAdapter
    private fun setRecyclerView() {

        val linearLayout = LinearLayoutManager(context)
        todayAdapter = TodayRecyclerViewAdapter(null, this)
        binding.todayRecyclerView.layoutManager = linearLayout
        binding.todayRecyclerView.adapter = todayAdapter

    }

    private fun setObserver() {
        viewModel.getNews("home").observe(viewLifecycleOwner, Observer { result ->
            todayAdapter.updateList(result.data)
            Log.d("taggg", "${(result.data?.size ?: 0)}")

            binding.progressBar.isVisible =
                result is Resource.Loading && result.data.isNullOrEmpty()
            viewModel.loadingAnimation.postValue(result is Resource.Loading && result.data.isNullOrEmpty())

            //  binding.error.text = result.error?.localizedMessage ?: "yoyo"

            if (result is Resource.Success) {
                Snackbar.make(
                    binding.root,
                    "News Has been updated",
                    Snackbar.LENGTH_SHORT
                )
                    .show()
            }

            startNetworkCheck = true
        })

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun itemClicked(url: String) {
        val action = TodayFragmentDirections.actionTodayFragmentToArticelViewFragment(url)
        Navigation.findNavController(binding.root).navigate(action)
    }

}