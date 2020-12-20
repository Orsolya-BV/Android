package com.example.restaurants.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.restaurants.data.restaurants.CitiesResponseData
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


/*
    fun getRestaurant()
    {
        viewModelScope.launch {
            val response = repository.getRestaurant()
            myResponse.value = response
        }
    }

*/

    /*
    fun getRestaurant(options:Map<String,String>)
    {
        viewModelScope.launch {
            val response:Response<List<Restaurant>> = repository.getRestaurant(options)
            myResponse.value = response
        }
    }


    val myResponse = MutableLiveData<Response<List<Restaurant>>>()
     fun getLondonRestaurants(city:String)
    {
        viewModelScope.launch {
            val response:Response<List<Restaurant>> = repository.getLondonRestaurants(city)
            myResponse.value = response
        }
    }

    suspend fun getLondonRestaurantsWithPrice2(city:String,price:Int)
    {
        viewModelScope.launch { 
            val response: Response<List<Restaurant>> = repository.getLondonRestaurantsWithPrice2(city,price)
            myResponse.value = response
        }
    }

     */
val myResponse:MutableLiveData<Response<RestaurantResponseData>> = MutableLiveData()
     fun getRestaurants(id:Int,city:String)
    {
        viewModelScope.launch {
            val response:Response<RestaurantResponseData> = repository.getRestaurants(id,city)
            myResponse.value = response
        }
    }

    val cities:MutableLiveData<Response<CitiesResponseData>> = MutableLiveData()

     fun getCities()
    {
        viewModelScope.launch {
            val response:Response<CitiesResponseData> = repository.getCities()
            cities.value = response
        }
    }
}