package com.example.nytimes.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.nytimes.remote.network.NewsApi
import com.example.nytimes.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TodayViewModel @Inject constructor(
   repository:NewsRepository
) : ViewModel() {

    val news = repository.getNews().asLiveData()


    init {

    }

}