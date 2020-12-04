package com.example.idegesvendeglo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.idegesvendeglo.data.user.User
import com.example.idegesvendeglo.data.user.UserViewModel
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

        //val go = view.findViewById<FloatingActionButton>(R.id.floatingActionButton)
        //go.setOnClickListener {


               // findNavController().navigate(R.id.action_profileFragment_to_addFragment)

         //   Toast.makeText(context,"sikerult",Toast.LENGTH_LONG).show()

       // }
        return view
    }


}