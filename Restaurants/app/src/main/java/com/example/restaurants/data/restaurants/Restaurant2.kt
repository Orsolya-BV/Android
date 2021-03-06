package com.example.restaurants.data.restaurants

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Restaurants")
class Restaurant2 (
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val name:String,
    val adress:String,
    val city:String,
    val state:String,
    val area:String,
    val postal_code:String,
    val country:String,
    val phone_number:String,
    val lat:Float,
    val lng:Float,
    val price:Int,
    val reserve_url:String,
    val mobile_reserve_url:String,
    var image_url:String
)