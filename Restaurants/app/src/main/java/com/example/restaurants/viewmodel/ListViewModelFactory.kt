package com.example.restaurants.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.restaurants.repository.ApiRepository

class ListViewModelFactory(private val repository: ApiRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
       return ListViewModel(repository) as T
    }
}