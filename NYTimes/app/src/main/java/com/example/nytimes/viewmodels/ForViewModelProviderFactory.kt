package com.example.nytimes.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.nytimes.repository.YouRepository

class ForViewModelProviderFactory(val youRepository: YouRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ForYouViewModel(youRepository) as T
    }
}