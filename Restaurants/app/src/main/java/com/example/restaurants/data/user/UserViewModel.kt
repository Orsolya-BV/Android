package com.example.restaurants.data.user

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.restaurants.data.restaurants.RestaurantDatabase
import com.example.restaurants.repository.ApiRepository
import com.example.restaurants.repository.DatabaseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application):AndroidViewModel(application) {



    private val repository: DatabaseRepository

    init {
        val userDao = RestaurantDatabase.getDatabase(application).restaurantDao()
        repository = DatabaseRepository(userDao)
    }

    fun addUser(user: User)
    {
         viewModelScope.launch(Dispatchers.IO) {
         repository.addUser(user)
        }
    }

/*
    fun readAllData():LiveData<User>
    {
        return repository.readAllData()
    }

    fun activeUser(): LiveData<User>
    {
        return repository.activeUser()
    }*/
}