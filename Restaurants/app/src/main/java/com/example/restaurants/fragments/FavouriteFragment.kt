package com.example.restaurants.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurants.R
import com.example.restaurants.data.restaurants.Restaurant
import com.example.restaurants.data.restaurants.RestaurantFavoritAdapter
import com.example.restaurants.repository.ApiRepository
import com.example.restaurants.viewmodel.ListViewModel
import com.example.restaurants.viewmodel.ListViewModelFactory


class FavouriteFragment : Fragment() {

    lateinit var  recyclerView:RecyclerView
    lateinit var list:MutableList<Restaurant>
    lateinit var viewModel:ListViewModel
    lateinit var listViewModelFactory:ListViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favourite, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.favourite_recyclerView)
        val repository = ApiRepository()
        val listViewModelFactory = ListViewModelFactory(repository)
        viewModel = ViewModelProvider(requireActivity(),listViewModelFactory).get(ListViewModel::class.java)
        val list = viewModel.favorit

        val recyclerViewAdapter = RestaurantFavoritAdapter(list)

        recyclerView.adapter = recyclerViewAdapter
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)

    }
    }
