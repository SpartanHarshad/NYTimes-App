package com.example.nytimes.viewmodels


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.nytimes.model.Result
import com.example.nytimes.repository.MostPopularNewsRepo
import kotlinx.coroutines.Dispatchers


class MostPopularNewsviewModel(val newsRepository:MostPopularNewsRepo) : ViewModel() {

    fun mostPopularNewsModel():LiveData<List<Result>> {
        return liveData(Dispatchers.IO) {
            val Result = newsRepository.getMostPopularNews()
            emit(Result!!.results!!)
        }
    }
}
