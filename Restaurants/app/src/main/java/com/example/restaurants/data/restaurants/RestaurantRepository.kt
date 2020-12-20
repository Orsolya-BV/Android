package com.example.restaurants.data.restaurants

import androidx.lifecycle.LiveData

class RestaurantRepository(private val restaurantDao: RestaurantDao) {
    suspend fun addRestaurant(restaurant: Restaurant)
    {
        restaurantDao.addRestaurant(restaurant)
    }

    fun readAllData(): LiveData<List<Restaurant>>
    {
        return restaurantDao.readAllData()
    }

    fun getOneRestaurantById(id:Int):LiveData<Restaurant>
    {
        return restaurantDao.getOneRestaurantById(id)
    }


    fun getFavouriteRestaurant():LiveData<List<Restaurant>>
    {
        return restaurantDao.getFavouriteRestaurant()
    }

    suspend fun deleteRestaurant(restaurant: Restaurant)
    {
        restaurantDao.deleteRestaurant(restaurant)
    }

}