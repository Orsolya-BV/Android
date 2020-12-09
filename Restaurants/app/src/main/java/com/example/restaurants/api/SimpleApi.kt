package com.example.restaurants.api

import com.example.restaurants.data.restaurants.Restaurant
import com.example.restaurants.data.restaurants.RestaurantResponseData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap


interface SimpleApi {

    @GET("restaurants")
    suspend fun getLondonRestaurants(
            @Query("city")city:String

    ):Response<List<Restaurant>>

    @GET("restaurants")
    suspend fun getLondonRestaurantsWithPrice2(
            @Query("city")city: String,
            @Query("price")price:Int
    ):Response<List<Restaurant>>
//suspend fun getRestaurant():Response<Restaurant>
}