package com.example.restaurants.repository

import com.example.restaurants.data.restaurants.RestaurantDao
import com.example.restaurants.data.user.User

class DatabaseRepository(val dao: RestaurantDao) {

    suspend fun addUser(user: User)
    {
        dao.addUser(user)
    }
}