package com.example.nytimes.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nytimes.api.Resource
import com.example.nytimes.model.Article
import com.example.nytimes.model.NewsResponse
import com.example.nytimes.repository.YouRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class ForYouViewModel(val youRepository: YouRepository) : ViewModel() {

    val foryouNews: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    var foryouNewsPage = 1

    init {
        getBreakingNews("us")
    }

    fun getBreakingNews(countryCode: String) = viewModelScope.launch {
        foryouNews.postValue(Resource.Loading())
        val response = youRepository.getBreakingNews(countryCode, foryouNewsPage)
        foryouNews.postValue(handleForyouNewsResponse(response))
    }

    private fun handleForyouNewsResponse(response: Response<NewsResponse>) : Resource<NewsResponse> {
        if(response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }

    fun saveArticle(article: Article) = viewModelScope.launch {
        youRepository.upsert(article)
    }
    fun getSavedNews()= youRepository.getSavedNews()


    fun deleteArticle(article: Article)= viewModelScope.launch {
        youRepository.deleteArticle(article)
    }
}