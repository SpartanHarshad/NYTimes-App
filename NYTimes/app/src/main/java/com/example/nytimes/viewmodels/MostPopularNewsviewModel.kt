package com.example.nytimes.viewmodels


import androidx.lifecycle.*
import com.example.nytimes.local.entity.ArticleItemEntity
import com.example.nytimes.repository.MostPopularNewsRepo
import com.example.nytimes.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MostPopularNewsviewModel@Inject constructor(
    var repository: MostPopularNewsRepo
) : ViewModel() {

    //val news = repository.getNews().asLiveData()

    fun getNews(topic: String): LiveData<Resource<List<ArticleItemEntity>>> {
        return repository.getMostPopularNews(topic).asLiveData();
    }
    val loadingAnimation = MutableLiveData<Boolean>(true)

}