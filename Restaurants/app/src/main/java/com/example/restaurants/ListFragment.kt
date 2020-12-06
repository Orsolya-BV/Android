package com.example.restaurants

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurants.data.restaurants.RestaurantViewAdapter


class ListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
private lateinit var layoutManager: RecyclerView.LayoutManager
private lateinit var recyclerViewA: RestaurantViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


      //recyclerView = requireView().findViewById<RecyclerView>(R.id.restaurant_recyclerview)
       // recyclerView.setHasFixedSize(true)
        //recyclerView.layoutManager = LinearLayoutManager(context)



        val view = inflater.inflate(R.layout.fragment_list, container, false)
        return view
    }


}