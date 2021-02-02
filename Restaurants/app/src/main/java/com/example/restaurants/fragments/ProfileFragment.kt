package com.example.restaurants.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.restaurants.R
import com.example.restaurants.data.user.User
import com.example.restaurants.data.user.UserViewModel

class ProfileFragment : Fragment() {

  lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val userName = view?.findViewById<TextView>(R.id.editedName)
        val userAdress = view?.findViewById<TextView>(R.id.editedAdress)
        val userPhone = view?.findViewById<TextView>(R.id.editedPhone)
        val userEmail = view?.findViewById<TextView>(R.id.editedEmail)


        mUserViewModel = ViewModelProvider(requireActivity()).get(UserViewModel::class.java)

        userName.text = mUserViewModel.userValue?.user_name
        userAdress.text = mUserViewModel.userValue?.user_adress
        userEmail.text = mUserViewModel.userValue?.user_email
        userPhone.text = mUserViewModel.userValue?.user_phone_number
        Log.d("Cokie",mUserViewModel.userValue.toString())

    }
}