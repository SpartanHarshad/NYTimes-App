package com.example.nytimes.viewmodels

import androidx.lifecycle.*
import com.example.nytimes.local.entity.ArticleItemEntity
import com.example.nytimes.repository.USNewsRepo
import com.example.nytimes.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class USNewsViewModel@Inject constructor(var usNewsRepo: USNewsRepo):ViewModel() {

    fun USNewsModel(topic: String): LiveData<Resource<List<ArticleItemEntity>>> {
        return usNewsRepo.getUSNews(topic).asLiveData();
    }

    val loadingAnimation = MutableLiveData<Boolean>(true)
}