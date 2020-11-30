package com.example.idegesvendeglo.data.restaurants

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.idegesvendeglo.data.user.User
import com.example.idegesvendeglo.data.user.UserDao


@Database(entities = [User::class],version = 1,exportSchema = false)
abstract class RestaurantDatabase: RoomDatabase() {

    abstract fun userDao(): UserDao

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
                ).build()
                INSTANCE = instance
                return instance

            }
        }
    }
}