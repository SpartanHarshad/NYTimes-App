package com.example.nytimes.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.nytimes.local.entity.ArticleItemEntity
import com.example.nytimes.repository.NewsRepository
import com.example.nytimes.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(var repository: NewsRepository) : ViewModel() {

    fun getNews(topic: String): LiveData<Resource<List<ArticleItemEntity>>> {
        return repository.getNews(topic).asLiveData();
    }

    fun getMostPopularNews(topic: String): LiveData<Resource<List<ArticleItemEntity>>> {
        return repository.getMostPopularNews(topic).asLiveData();
    }

    val loadingAnimation = MutableLiveData<Boolean>(true)

}