package com.example.nytimes.viewmodels

import androidx.lifecycle.ViewModel
import com.example.nytimes.remote.network.NewsApi
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TodayViewModel @Inject constructor(
    api: NewsApi
) : ViewModel() {

    init {

    }

}