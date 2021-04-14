package com.example.nytimes.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.nytimes.repository.SectionRepository

class AllSectionsViewModelFactory(val repository: SectionRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AllSectionsViewModel(repository) as T
    }
}