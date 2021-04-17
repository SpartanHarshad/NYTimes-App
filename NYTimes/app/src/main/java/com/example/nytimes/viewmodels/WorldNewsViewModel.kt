package com.example.nytimes.viewmodels

import androidx.lifecycle.*
import com.example.nytimes.local.entity.ArticleItemEntity
import com.example.nytimes.repository.WorldNewsRepo
import com.example.nytimes.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WorldNewsViewModel@Inject constructor(var worldNewsRepo: WorldNewsRepo):ViewModel() {

    fun worldNewsModel(topic: String): LiveData<Resource<List<ArticleItemEntity>>> {
        return worldNewsRepo.getWorldNews(topic).asLiveData();
    }
    val loadingAnimation = MutableLiveData<Boolean>(true)
}