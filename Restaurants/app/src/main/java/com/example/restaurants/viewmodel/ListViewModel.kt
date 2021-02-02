package com.example.restaurants.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.restaurants.data.restaurants.Restaurant
import com.example.restaurants.repository.ApiRepository
import kotlinx.coroutines.launch

class ListViewModel(private val repository: ApiRepository) :ViewModel(){



    val myResponse = MutableLiveData<MutableList<Restaurant>>()
    var myValue:Int  = 0
    //gets the data from the api and passes to the myResponse variable
    fun getAllRestaurants()
    {
        viewModelScope.launch {
            val response= repository.getAllRestaurants()
            myResponse.value = response.body()?.restaurants
        }
    }


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



    suspend fun getLondonRestaurantsWithPrice2(city:String,price:Int)
    {
        viewModelScope.launch { 
            val response: Response<List<Restaurant>> = repository.getLondonRestaurantsWithPrice2(city,price)
            myResponse.value = response
        }
    }

     */






    /*
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

     */
}