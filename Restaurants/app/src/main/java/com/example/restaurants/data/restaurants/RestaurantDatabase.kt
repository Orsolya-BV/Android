package com.example.restaurants.data.restaurants

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.restaurants.data.user.User


@Database(entities = [Restaurant2::class, User::class],version = 3,exportSchema = false)
abstract class RestaurantDatabase: RoomDatabase() {

    abstract fun restaurantDao(): RestaurantDao

    companion object
    {
        @Volatile
        private var INSTANCE: RestaurantDatabase? = null

        fun getDatabase(context: Context): RestaurantDatabase
        {
            val tempInstance = INSTANCE
            if(tempInstance != null)
            {
                return tempInstance
            }
            synchronized(this)
            {
                val instance = Room.databaseBuilder(
                        context.applicationContext,RestaurantDatabase::class.java,
                        "restaurant_database"
                ).fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance

            }
        }
    }
}