package com.example.restaurants.repository

import com.example.restaurants.api.RetrofitInstance
import com.example.restaurants.data.restaurants.Restaurant
import retrofit2.Response

class Repository {

    /*
    suspend fun getRestaurant(options: Map<String, String>):Response<List<Restaurant>>
    {
        return RetrofitInstance.api.getRestaurant(options)
    }
*/

    /*
    suspend fun getRestaurant():Response<Restaurant>
    {
        return RetrofitInstance.api.getRestaurant()
    }
    */

    suspend fun getLondonRestaurants(city:String):Response<List<Restaurant>>
    {
        return RetrofitInstance.api.getLondonRestaurants(city)
    }

    suspend fun getLondonRestaurantsWithPrice2(city:String,price:Int):Response<List<Restaurant>>
    {
        return RetrofitInstance.api.getLondonRestaurantsWithPrice2(city,price)
    }
}