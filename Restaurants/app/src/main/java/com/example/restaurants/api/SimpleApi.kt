package com.example.restaurants.api

import com.example.restaurants.data.restaurants.Restaurant
import com.example.restaurants.data.restaurants.RestaurantResponseData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap


interface SimpleApi {
    @GET("restaurants")
    suspend fun getRestaurant(
        @QueryMap options:Map<String,String>
    ):Response<List<Restaurant>>
//suspend fun getRestaurant():Response<Restaurant>
}