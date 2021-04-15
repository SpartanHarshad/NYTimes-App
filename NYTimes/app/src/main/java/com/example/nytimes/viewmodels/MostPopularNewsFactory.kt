package com.example.nytimes.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.nytimes.repository.MostPopularNewsRepo

class MostPopularNewsFactory(var mostPopularNewsRepo: MostPopularNewsRepo) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MostPopularNewsviewModel(mostPopularNewsRepo) as T
    }
}