package com.example.nytimes.viewmodels

import androidx.lifecycle.ViewModel
import com.example.nytimes.model.MostPopular
import com.example.nytimes.repository.MostPopularNewsRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MostPopularNewsviewModel(val mostPopularNewsRepo: MostPopularNewsRepo) : ViewModel() {

    fun getMostPopularNewsModel(): MostPopular {
        var mostPopular = MostPopular()
        CoroutineScope(Dispatchers.IO).launch {
            mostPopular = mostPopularNewsRepo.getMostPopularNews()
        }
        return mostPopular
    }
}