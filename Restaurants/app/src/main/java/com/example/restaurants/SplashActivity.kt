package com.example.restaurants

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val image:ImageView = findViewById(R.id.logo_image)
        val title:TextView = findViewById(R.id.title_restaurants)

        var myanimation:Animation = AnimationUtils.loadAnimation(this,R.anim.animaton)

        image.startAnimation(myanimation)
        title.startAnimation(myanimation)

        val time = 3000

        val intent = Intent(this,MainActivity::class.java)

        Handler().postDelayed(
            {
                startActivity(intent)
                finish()
            },time.toLong()
        )


    }
}