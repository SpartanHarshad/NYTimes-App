package com.example.nytimes.fragments.search_fragment.view_model

import androidx.lifecycle.ViewModel
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.nytimes.fragments.search_fragment.paging.NewsRemoteMediator
import com.example.nytimes.local.database.NewsDatabase
import com.example.nytimes.remote.network.NewsApi

import com.example.nytimes.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    var repository: NewsRepository,
    private val api: NewsApi,
    private val db: NewsDatabase
) : ViewModel() {

    val newsDao = db.getDao()

    @ExperimentalPagingApi
    val pager = Pager(PagingConfig(pageSize = 10), remoteMediator = NewsRemoteMediator(db, api, 1)){
        newsDao.getAllSearch("android")
    }.flow


}