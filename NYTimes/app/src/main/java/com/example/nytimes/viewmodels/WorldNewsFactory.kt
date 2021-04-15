package com.example.nytimes.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.nytimes.repository.WorldNewsRepo

class WorldNewsFactory(val worldNewsRepo: WorldNewsRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return WorldNewsViewModel(worldNewsRepo) as T
    }
}