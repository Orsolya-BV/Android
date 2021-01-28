package com.example.restaurants.api


import com.example.restaurants.data.restaurants.Restaurant
import com.example.restaurants.data.restaurants.RestaurantResponseData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap


interface SimpleApi {

    @GET("restaurants")
    suspend fun getAllRestaurants(
    ):Response<RestaurantResponseData>



    @GET("restaurants")
    suspend fun getRestaurants(
        @Query("id")id:Int,
        @Query("city")city:String
    ):Response<RestaurantResponseData>

//suspend fun getRestaurant():Response<Restaurant>
}