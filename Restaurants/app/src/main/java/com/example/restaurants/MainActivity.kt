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
import com.example.restaurants.fragments.FavouriteFragment
import com.example.restaurants.fragments.ListFragment
import com.example.restaurants.fragments.ProfileFragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener{

    lateinit var  mDrawer: DrawerLayout
    lateinit var profileFragment: ProfileFragment
    lateinit var addFragment: AddFragment
    lateinit var listFragment: ListFragment
    lateinit var favouriteFragment:FavouriteFragment
    lateinit var toolbar:Toolbar
    lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        mDrawer =findViewById<DrawerLayout>(R.id.mDrawer)


        profileFragment = ProfileFragment()
        listFragment = ListFragment()
        addFragment = AddFragment()
        favouriteFragment = FavouriteFragment()

        navigationView =findViewById<NavigationView>(R.id.navigation)
        navigationView.setNavigationItemSelectedListener(this)




    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        //letrehozzuk a fragmentseket
        when(item.itemId)
        {
            R.id.go_profile -> {
                this.profileFragment = ProfileFragment()
                supportFragmentManager.beginTransaction()
                        .replace(R.id.nav_host_fragment, profileFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
            }
            R.id.go_restaurants -> {
                this.listFragment = ListFragment()
                supportFragmentManager.beginTransaction()
                        .replace(R.id.nav_host_fragment, listFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
            }

            R.id.go_login-> {
                this.addFragment = AddFragment()
                supportFragmentManager.beginTransaction()
                        .replace(R.id.nav_host_fragment, addFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
            }

            R.id.go_favourite ->{
                this.favouriteFragment = FavouriteFragment()
                supportFragmentManager.beginTransaction()
                        .replace(R.id.nav_host_fragment,favouriteFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
            }

        }
        mDrawer.closeDrawer(GravityCompat.START)
        return true
    }



}