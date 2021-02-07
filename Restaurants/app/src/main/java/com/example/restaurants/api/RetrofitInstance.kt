package com.example.restaurants.api

import com.example.restaurants.util.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
          //  .baseUrl("https://ratpark-api.imok.space/")
                .baseUrl("https://us-central1-local-trader-2-0.cloudfunctions.net/API/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api:SimpleApi by lazy {
        retrofit.create(SimpleApi::class.java)
    }
}