package com.example.restaurants.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurants.R
import com.example.restaurants.data.restaurants.Restaurant
import com.example.restaurants.data.restaurants.RestaurantAdapter
import com.example.restaurants.data.restaurants.RestaurantListAdapter
import com.example.restaurants.data.restaurants.RestaurantViewModel
import com.example.restaurants.repository.Repository
import com.example.restaurants.viewmodel.ListViewModel
import com.example.restaurants.viewmodel.ListViewModelFactory

class ListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    //private lateinit var layoutManager: RecyclerView.LayoutManager
  //  private lateinit var recyclerViewA: RestaurantViewAdapter
//
    private lateinit var restaurantViewModel: RestaurantViewModel

    private lateinit var viewModel: ListViewModel
    private val myAdapter by lazy {
        RestaurantListAdapter()
    }
    lateinit var restaurants:List<Restaurant>
    lateinit var view:AutoCompleteTextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        recyclerView = view?.findViewById<RecyclerView>(R.id.restaurant_recyclerview)!!

        recyclerView.adapter = myAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        //setupRecyclerView()

        val repository = Repository()
        val viewModelFactory = ListViewModelFactory(repository)
        this.viewModel = ViewModelProvider(this, viewModelFactory).get(ListViewModel::class.java)

       // var name = view?.findViewById<TextView>(R.id.search)?.text.toString()
//set cities
        viewModel.getCities()
        viewModel.cities.observe(viewLifecycleOwner) { response ->
            if (response.isSuccessful) {
                val cities: List<String> = response.body()!!.cities
                //view

            }
        }


        // viewModel.getLondonRestaurants("London")
       // viewModel.getLondonRestaurantsWithPrice2("London",2)
      /*  viewModel.myResponse.observe(viewLifecycleOwner
        ) { response ->
            if (response.isSuccessful) {
                response.body()?.let { myAdapter.setData(it) }
            }else
            {
                Toast.makeText(context,response.code(),Toast.LENGTH_LONG).show()
            }
        }

       */
        return view

    }

}