package com.example.restaurants.data.restaurants

data class RestaurantResponseData (
    val total_entries:Int,
    val page:Int,
    val per_page:Int,
    val restaurants:MutableList<Restaurant>
)


