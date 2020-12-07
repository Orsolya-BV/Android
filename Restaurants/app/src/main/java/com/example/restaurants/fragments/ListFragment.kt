package com.example.restaurants.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurants.R
import com.example.restaurants.data.restaurants.RestaurantViewAdapter
import com.example.restaurants.data.restaurants.RestaurantViewModel
import com.example.restaurants.repository.Repository
import com.example.restaurants.viewmodel.ListViewModel
import com.example.restaurants.viewmodel.ListViewModelFactory


class ListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var recyclerViewA: RestaurantViewAdapter

    private val restaurantViewModel by lazy {
        activity?.application?.let {
            RestaurantViewModel(application = it)
        }
    }


    private lateinit var viewModel: ListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       // recyclerView = requireView().findViewById<RecyclerView>(R.id.restaurant_recyclerview)
        //recyclerView.setHasFixedSize(true)

        val repository = Repository()
        val viewModelFactory = ListViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(ListViewModel::class.java)

        restaurantViewModel?.getFavouriteRestaurant()
/*
        val options:HashMap<String,String> = HashMap()

        options["_sort"] = "id"
        options["_order"] = "desc"
        viewModel.getRestaurant(options)

        viewModel.myResponse.observe(this, Observer {
            response ->
            if(response.isSuccessful)
            {
                response.body()?.forEach {
                    Log.d("Response", it.id.toString())
                    // Log.d("Response", response.body()?.name!!)

                  Log.d( "Response",it.name!!)
                    }
                    Log.d("Response", it.adress!!)
                    Log.d("Response", it.city!!)
                    Log.d("Response", it.state!!)
                    Log.d("Response", it.area!!)
                    Log.d("Response", it.postal_code!!)
                    Log.d("Response", it.country!!)
                    Log.d("Response", it.phone_number!!)
                    Log.d("Response",it.lat.toString())
                    Log.d("Response",it.lng.toString())
                    Log.d("Response", it.price.toString())
                    Log.d("Response",it.reserve_url!!)
                    Log.d("Response",it.mobile_reserve_url!!)
                    Log.d("Response", it.image_url!!)
                    Log.d("Response", it.favourite.toString())
                    Log.d("Response", it.new_image.toString())
                }
            }else
            {
                Log.d("Response",response.errorBody().toString())
                if (textView != null) {
                    textView.text = response.code().toString()
                }
            }

        })
*/

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //recyclerView.layoutManager = LinearLayoutManager(context)
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        return view
    }



}