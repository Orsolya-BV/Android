package com.example.restaurants.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.restaurants.R
import com.example.restaurants.data.user.User
import com.example.restaurants.data.user.UserViewModel

class ProfileFragment : Fragment() {

   private val  userViewModel by lazy { activity?.application?.let { UserViewModel(it) } }
  private var user: User? =null
    private var outName:String? = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        val view = inflater.inflate(R.layout.fragment_profile, container, false)

      //  val name = intent.getStringExtra("name")
      //  val adress = intent.getStringExtra("adress")
      //  val email = intent.getStringExtra("email")
      //  val phone = intent.getStringExtra("phone")
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}