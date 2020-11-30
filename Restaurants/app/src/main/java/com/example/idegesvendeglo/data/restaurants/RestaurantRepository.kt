package com.example.idegesvendeglo.data.restaurants

import androidx.lifecycle.LiveData
import com.example.idegesvendeglo.data.user.User

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

    fun deleteRestaurant(restaurant: Restaurant)
    {
        restaurantDao.deleteRestaurant(restaurant)
    }

}