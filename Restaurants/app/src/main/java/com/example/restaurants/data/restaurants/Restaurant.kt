package com.example.restaurants.data.restaurants

import androidx.room.Entity
import androidx.room.PrimaryKey

data class Restaurant(
        val id:Int,
        val name:String,
        val address:String,
        val city:String,
        val state:String,
        val area:String,
        val postal_code:String,
        val country:String,
        val phone:String,
        val lat:Float,
        val lng:Float,
        val price:Float,
        val reserve_url:String,
        val mobile_reserve_url:String,
        var image_url:String

)
