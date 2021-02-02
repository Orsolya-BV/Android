package com.example.restaurants.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.restaurants.R
import com.example.restaurants.repository.ApiRepository
import com.example.restaurants.viewmodel.ListViewModel
import com.example.restaurants.viewmodel.ListViewModelFactory

class SplashFragment : Fragment() {

    private lateinit var listViewModel:ListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val repository = ApiRepository()
        val listViewModelFactory = ListViewModelFactory(repository)
        listViewModel = ViewModelProvider(requireActivity(),listViewModelFactory).get(ListViewModel::class.java)


        listViewModel.myResponse.observe(requireActivity(), androidx.lifecycle.Observer {
            findNavController().navigate(R.id.action_splashFragment_to_listFragment)
        } )

        listViewModel.getAllRestaurants()





    }
}