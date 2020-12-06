package com.example.restaurants.data.restaurants

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurants.DetailsFragment
import com.example.restaurants.ListFragment
import com.example.restaurants.R


class RestaurantViewAdapter(private var restaurant: ListFragment, private val listener: AdapterView.OnItemClickListener):
RecyclerView.Adapter<RestaurantViewAdapter.RestaurantViewHolder>() {

    private var restaurantList: MutableList<Restaurant> = mutableListOf()
    private val page = 0
    private var room = true

    inner class RestaurantViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        val name: TextView = itemView.findViewById(R.id.name_restaurant)
        val adress: TextView = itemView.findViewById(R.id.Adress_restaurant)
        val phone: TextView = itemView.findViewById(R.id.phone_restaurant)
        val favourite: ImageView = itemView.findViewById(R.id.favorit_restaurant)

        init {
            itemView.setOnClickListener(this);
            favourite.setOnClickListener(this);
        }

        override fun onClick(v: View?) {
            //val position: Int = adapterPosition
            //if (position != RecyclerView.NO_POSITION) {
              //  if (v?.id == favourite.id) {

                //} else {
                  //  //listener.onItemClick(position)
                //}
            //}
            Log.d("Recycleriew","Clicked!!")
            val context = v?.context
            val detailsFragment = DetailsFragment()

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewAdapter.RestaurantViewHolder {
        return RestaurantViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_example,parent,false))

    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }


}

