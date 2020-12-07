package com.example.restaurants.data.restaurants

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RestaurantViewModel(application: Application): AndroidViewModel(application) {

    private val repository: RestaurantRepository

    init {
        val restaurantDao = RestaurantDatabase.getDatabase(application).restaurantDao()
        repository = RestaurantRepository(restaurantDao)


    }

    fun addRestaurant(restaurant: Restaurant) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addRestaurant(restaurant)
        }
    }


    fun readAllData(): LiveData<List<Restaurant>> {
        return repository.readAllData()
    }

    fun getOneRestaurantById(id:Int):LiveData<Restaurant>
    {
        return repository.getOneRestaurantById(id)
    }

    fun getFavouriteRestaurant():LiveData<List<Restaurant>>
    {
        return repository.getFavouriteRestaurant()
    }

    fun deleteRestaurant(restaurant: Restaurant)
    {
        repository.deleteRestaurant(restaurant)
    }
}

    private fun RestaurantDatabase.restaurantDao(): RestaurantDao {
            return restaurantDao()
        }

