package com.example.restaurants.data.restaurants

data class RestaurantResponseData (
    val total_entries:Int,
    val per_page:Int,
    val page:Int,
    val restaurant:List<Restaurant>
)

data class CitiesResponseData(
    val cities:List<String>
)

