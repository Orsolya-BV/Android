package com.example.restaurants

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import java.util.*

class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {

    lateinit var  mDrawer: DrawerLayout
    lateinit var profileFragment:ProfileFragment
    lateinit var addFragment: AddFragment
    lateinit var listFragment: ListFragment
   lateinit var toolbar:Toolbar
    lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //this.toolbar =findViewById<Toolbar>(R.id.toolbar)
        //setSupportActionBar(toolbar)
        mDrawer =findViewById<DrawerLayout>(R.id.mDrawer)

         profileFragment = ProfileFragment()
         listFragment = ListFragment()
         addFragment = AddFragment()


        navigationView =findViewById<NavigationView>(R.id.navigation)
        //val toggle = ActionBarDrawerToggle(this,mDrawer,toolbar,0,0)
        //mDrawer.addDrawerListener(toggle)
        navigationView.setNavigationItemSelectedListener(this)


    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
       //letrehozzuk a fragmentseket
        when(item.itemId)
        {
            R.id.go_profile -> {
                this.profileFragment = ProfileFragment()
                supportFragmentManager.beginTransaction()
                        .replace(R.id.flContent, profileFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
            }
            R.id.go_restaurants -> {
                this.listFragment = ListFragment()
                supportFragmentManager.beginTransaction()
                        .replace(R.id.flContent, listFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
            }

            R.id.go_login-> {
                this.addFragment = AddFragment()
                supportFragmentManager.beginTransaction()
                        .replace(R.id.flContent, addFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
            }


        }
        mDrawer.closeDrawer(GravityCompat.START)
        return true
    }


}