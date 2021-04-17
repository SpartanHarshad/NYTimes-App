package com.example.nytimes.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.nytimes.local.entity.ArticleItemEntity
import com.example.nytimes.repository.PoliticsRepo
import com.example.nytimes.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PoliticsViewModel@Inject constructor(var politicsRepo: PoliticsRepo):ViewModel() {

    fun polNewsModel(topic: String): LiveData<Resource<List<ArticleItemEntity>>> {
        return politicsRepo.getPoliticsNews(topic).asLiveData();
    }

    val loadingAnimation = MutableLiveData<Boolean>(true)
}