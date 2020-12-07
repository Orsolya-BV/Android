package com.example.restaurants.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.restaurants.data.restaurants.Restaurant
import com.example.restaurants.data.restaurants.RestaurantResponseData
import com.example.restaurants.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class ListViewModel(private val repository: Repository) :ViewModel(){
/*
    val myResponse:MutableLiveData<Response<RestaurantResponseData>> = MutableLiveData()
    fun getRestaurant(options:Map<String,String>)
    {
        viewModelScope.launch {
            val response = repository.getRestaurant(options)
           // myResponse.value = response
        }
    }
*/

    val myResponse:MutableLiveData<Response<List<Restaurant>>> = MutableLiveData()
/*
    fun getRestaurant()
    {
        viewModelScope.launch {
            val response = repository.getRestaurant()
            myResponse.value = response
        }
    }

*/

    fun getRestaurant(options:Map<String,String>)
    {
        viewModelScope.launch {
            val response:Response<List<Restaurant>> = repository.getRestaurant(options)
            myResponse.value = response
        }
    }
}