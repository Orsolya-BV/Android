package com.example.restaurants.data.restaurants

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.restaurants.data.user.User

@Dao
interface RestaurantDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUser(user: User)

   /* @Insert(onConflict = OnConflictStrategy.REPLACE)

    suspend fun addRestaurant(restaurant: Restaurant)

    @Query("SELECT * FROM restaurant_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Restaurant>>


    @Query("SELECT * FROM restaurant_table WHERE id == :id ")
    fun getOneRestaurantById(id:Int):LiveData<Restaurant>

    @Query("SELECT * FROM restaurant_table WHERE favourite == 1")
    fun getFavouriteRestaurant():LiveData<List<Restaurant>>

    @Delete()
   suspend fun deleteRestaurant(restaurant: Restaurant)

    */
}