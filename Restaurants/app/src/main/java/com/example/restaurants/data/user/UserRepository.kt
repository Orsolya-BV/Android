package com.example.restaurants.data.user

import androidx.lifecycle.LiveData

class UserRepository(private val userDao: UserDao) {


    suspend fun addUser(user: User)
    {
        userDao.addUser(user)
    }

    fun readAllData():LiveData<User>
    {
        return userDao.readAllData()
    }

    fun activeUser(): LiveData<User>
    {
        return userDao.activeUser()
    }
}