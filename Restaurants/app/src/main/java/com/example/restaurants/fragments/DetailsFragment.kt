package com.example.restaurants.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.addCallback
import androidx.lifecycle.ViewModelProvider
import com.example.restaurants.R
import com.example.restaurants.repository.Repository
import com.example.restaurants.viewmodel.ListViewModel
import com.example.restaurants.viewmodel.ListViewModelFactory


class DetailsFragment : Fragment() {

    private lateinit var viewModel:ListViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val repository = Repository()
        val listViewModelFactory = ListViewModelFactory(repository)
        viewModel = ViewModelProvider(requireActivity(),listViewModelFactory).get(ListViewModel::class.java)

        val restaurant = viewModel.myResponse.value?.get(viewModel.myValue)
        val name = view.findViewById<TextView>(R.id.details_name)
        val image = view.findViewById<ImageView>(R.id.details_image)
        val adress = view.findViewById<TextView>(R.id.details_adress)
        val phone = view.findViewById<TextView>(R.id.details_phone)
        val price = view.findViewById<TextView>(R.id.details_price)

        name.text = restaurant?.name
        adress.text = restaurant?.address
        phone.text = restaurant?.phone
        price.text = restaurant?.price.toString()


    }
}