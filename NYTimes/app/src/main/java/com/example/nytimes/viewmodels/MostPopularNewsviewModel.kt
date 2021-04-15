package com.example.nytimes.viewmodels

import android.net.DnsResolver
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.nytimes.model.MostPopular
import com.example.nytimes.model.Result
import com.example.nytimes.repository.MostPopularNewsRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MostPopularNewsviewModel(val newsRepository:MostPopularNewsRepo) : ViewModel() {

    fun mostPopularNewsModel():LiveData<List<Result>> {
        return liveData(Dispatchers.IO) {
            val Result = newsRepository.getMostPopularNews()
            emit(Result!!.results!!)
        }
    }
}
