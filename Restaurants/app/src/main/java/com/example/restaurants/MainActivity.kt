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
import com.example.restaurants.fragments.AddFragment
import com.example.restaurants.fragments.ListFragment
import com.example.restaurants.fragments.ProfileFragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {

    lateinit var  mDrawer: DrawerLayout
    lateinit var profileFragment: ProfileFragment
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

        //atvesszuk az adatokat
        val name = intent.getStringExtra("name")
        val adress = intent.getStringExtra("adress")
        val email = intent.getStringExtra("email")
        val phone = intent.getStringExtra("phone")



         profileFragment = ProfileFragment()
         listFragment = ListFragment()
         addFragment = AddFragment()


        navigationView =findViewById<NavigationView>(R.id.navigation)
        navigationView.setNavigationItemSelectedListener(this)
        //betesszuk a header elemeibe

      //  val headerView = navigationView.getHeaderView(0)
      //  headerView.findViewById<TextView>(R.id.header_name).text = name
      //  headerView.findViewById<TextView>(R.id.header_adress).text = adress
     //   headerView.findViewById<TextView>(R.id.header_email).text = email
       // headerView.findViewById<TextView>(R.id.header_phone).text = phone

        val headerView = navigationView.getHeaderView(0)
        val textView = headerView.findViewById<TextView>(R.id.header_name)
        textView.text = name
        headerView.findViewById<TextView>(R.id.header_adress).text = adress
        headerView.findViewById<TextView>(R.id.header_email).text = email
         headerView.findViewById<TextView>(R.id.header_phone).text = phone
        //textView.setText("alma")

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