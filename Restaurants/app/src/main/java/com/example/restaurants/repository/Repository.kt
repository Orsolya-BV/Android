package com.example.restaurants.repository

import com.example.restaurants.api.RetrofitInstance
import com.example.restaurants.data.restaurants.Restaurant
import retrofit2.Response

class Repository {

    suspend fun getRestaurant(options: Map<String, String>):Response<List<Restaurant>>
    {
        return RetrofitInstance.api.getRestaurant(options)
    }


    /*
    suspend fun getRestaurant():Response<Restaurant>
    {
        return RetrofitInstance.api.getRestaurant()
    }
    */
}