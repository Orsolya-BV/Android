package com.example.restaurants.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurants.R
import com.example.restaurants.data.restaurants.Restaurant
import com.example.restaurants.data.restaurants.RestaurantAdapter
import com.example.restaurants.repository.ApiRepository
import com.example.restaurants.viewmodel.ListViewModel
import com.example.restaurants.viewmodel.ListViewModelFactory

class ListFragment : Fragment(),RestaurantAdapter.OnItemClickListener {

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
        val repository = ApiRepository()
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
        val recyclerViewAdapter =RestaurantAdapter(
                list,this
        )
        recyclerView.adapter = recyclerViewAdapter
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)

        //search city
        val searchCity = view.findViewById<SearchView>(R.id.searchCity)
        searchCity.setOnQueryTextListener(object : SearchView.OnQueryTextListener
        {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
              recyclerViewAdapter.filter.filter(newText)
                recyclerView.recycledViewPool.clear()
                recyclerViewAdapter.notifyDataSetChanged()
                return true
            }

        })


    }

    override fun onItemClick(position: Int) {
        viewModel.myValue = position
        //navigate to details fragment
        findNavController().navigate(R.id.action_listFragment_to_detailsFragment)


    }

}