package com.example.restaurants

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.replace
import com.example.restaurants.fragments.AddFragment
import com.example.restaurants.fragments.ListFragment
import com.example.restaurants.fragments.ProfileFragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener{



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val drawerLayout = this.findViewById<DrawerLayout>(R.id.mDrawer)
        val navigationView = this.findViewById<NavigationView>(R.id.navigation)

      //  navigationView.onNavigationItemSelected(this)




    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when(item.itemId)
        {
            R.id.go_profile -> {
                //profile fragment
                val profileFragment = ProfileFragment()
                supportFragmentManager.beginTransaction().replace(R.id.profile,profileFragment).commit()
            }
            R.id.go_login ->
            {
                //login
                val loginFragment = AddFragment()
                supportFragmentManager.beginTransaction().replace(R.id.go_login,loginFragment).commit()
            }
        }
        return true
    }


}