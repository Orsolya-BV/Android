package com.example.restaurants

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val profileFragment = ProfileFragment()
       // val mainFragment = ListFragment()
        //makeCurrentFragment(profileFragment)

        /*
        val button = this.findViewById<BottomNavigationView>(R.id.bottom_navigation)
        button.setOnNavigationItemSelectedListener {
            when(it.itemId)
            {
                R.id.profile_menu ->makeCurrentFragment(profileFragment)
                R.id.restaurants_menu ->makeCurrentFragment(mainFragment)
            }
            true

        }




    }

    private fun makeCurrentFragment(fragment:Fragment) =
        supportFragmentManager.beginTransaction().apply {
        replace(R.id.next_fragment,fragment)
            commit()
    }

           */

    }}