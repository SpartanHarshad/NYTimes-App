package com.example.nytimes.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.nytimes.model.worldnews.Doc
import com.example.nytimes.repository.WorldNewsRepo
import kotlinx.coroutines.Dispatchers

class WorldNewsViewModel(var worldNewsRepo: WorldNewsRepo):ViewModel() {

    fun worldNewsModel(): LiveData<List<Doc>> {
        return liveData(Dispatchers.IO) {
            val Result = worldNewsRepo.getWorldNews()
            emit(Result!!.response!!.docs!!)
        }
    }
}