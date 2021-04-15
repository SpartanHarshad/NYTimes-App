package com.example.nytimes.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.nytimes.R
import com.example.nytimes.local.ForYouDatabase
import com.example.nytimes.repository.YouRepository
import com.example.nytimes.viewmodels.ForViewModelProviderFactory
import com.example.nytimes.viewmodels.ForYouViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: ForYouViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val youRepository = YouRepository(ForYouDatabase(this))
        val viewModelProviderFactory = ForViewModelProviderFactory(youRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(ForYouViewModel::class.java)

        bottomNavigationView.setupWithNavController(newsNavHostFragment.findNavController())
    }
}