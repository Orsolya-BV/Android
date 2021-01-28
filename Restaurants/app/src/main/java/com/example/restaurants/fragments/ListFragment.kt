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
import com.example.restaurants.data.restaurants.RestaurantAdapter
import com.example.restaurants.repository.Repository
import com.example.restaurants.viewmodel.ListViewModel
import com.example.restaurants.viewmodel.ListViewModelFactory

class ListFragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var list: MutableList<Restaurant>
    lateinit var viewModel: ListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //viewmodel
        val repository = Repository()
        val listViewModelFactory = ListViewModelFactory(repository)
        viewModel = ViewModelProvider(requireActivity(),listViewModelFactory).get(ListViewModel::class.java)
        val lista = viewModel.myResponse.value

        //recyclerview
        recyclerView = view.findViewById(R.id.restaurant_recyclerview)
        if (lista != null) {
            list = lista
        }
       /* var restaurant =Restaurant(1,"a","valami","a","a","a","a","a","a",1f,1f,
        1,"a","a","a",false)
        list.add(restaurant)

        */
        recyclerView.adapter = RestaurantAdapter(
            list
        )
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)
        
    }

}