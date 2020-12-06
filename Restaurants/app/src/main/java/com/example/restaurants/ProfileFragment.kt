package com.example.restaurants

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.restaurants.data.user.User
import com.example.restaurants.data.user.UserViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ProfileFragment : Fragment() {

   private val  userViewModel by lazy { activity?.application?.let { UserViewModel(it) } }
  private var user: User? =null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        val view = inflater.inflate(R.layout.fragment_profile, container, false)



        return view
    }


}