package com.example.nytimes.fragments.search_fragment.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.example.nytimes.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    var repository: NewsRepository
) : ViewModel() {

    val isInternetAvailable = MutableLiveData(false)
    val query = MutableLiveData("shooting")

    val news = query.switchMap {
        if (isInternetAvailable.value == true) repository.getSearchResults(it) else repository.searchInCache(
            it
        )
    }

}