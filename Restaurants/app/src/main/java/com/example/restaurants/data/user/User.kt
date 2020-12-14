package com.example.restaurants.data.user

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    val user_id:Int,
    val user_name:String,
    //val user_image:Int,
    val user_adress:String,
    val user_phone_number:String,
    val user_email:String
)