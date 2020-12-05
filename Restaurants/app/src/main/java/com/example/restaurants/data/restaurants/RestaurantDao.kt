package com.example.restaurants.data.restaurants

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface RestaurantDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE )

    suspend fun addRestaurant(restaurant: Restaurant)

    @Query("SELECT * FROM restaurant_table ORDER BY id ASC")

    fun readAllData(): LiveData<List<Restaurant>>

    @Query("SELECT * FROM restaurant_table WHERE id == :id ")
    fun getOneRestaurantById(id:Int):LiveData<Restaurant>

    //@Query("SELECT * FROM restaurant_table WHERE favourite == 1")

    fun getFavouriteRestaurant():LiveData<List<Restaurant>>

    @Delete()
    fun deleteRestaurant(restaurant: Restaurant)
}