package com.example.idegesvendeglo.data.user

import androidx.lifecycle.LiveData
import com.example.idegesvendeglo.data.user.User
import com.example.idegesvendeglo.data.user.UserDao

class UserRepository(private val userDao: UserDao) {


    suspend fun addUser(user: User)
    {
        userDao.addUser(user)
    }

    fun readAllData():LiveData<User>
    {
        return userDao.readAllData()
    }
}