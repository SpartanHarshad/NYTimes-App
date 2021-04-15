package com.example.nytimes.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.nytimes.model.Sections
import com.example.nytimes.repository.SectionRepository

class AllSectionsViewModel(val sectionRepository: SectionRepository):ViewModel() {

    fun allSectionsModel():List<Sections>{
        return sectionRepository.allSections()
    }
}