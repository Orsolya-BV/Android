package com.example.idegesvendeglo.data.restaurants

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.idegesvendeglo.ListFragment
import com.example.idegesvendeglo.R
import org.w3c.dom.Text
/*
class RestaurantListAdapter(private var restaurant: ListFragment,private val listener:AdapterView.OnItemClickListener):
RecyclerView.Adapter<RestaurantListAdapter.RestaurantListHolder>() {

    private var restaurantList: MutableList<Restaurant> = mutableListOf()
    private val page = 0
    private var room = true

    inner class RestaurantListHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        val name: TextView = itemView.findViewById(R.id.name_restaurant)
        val adress: TextView = itemView.findViewById(R.id.Adress_restaurant)
        val phone: TextView = itemView.findViewById(R.id.phone_restaurant)
        val favourite: ImageView = itemView.findViewById(R.id.favorit_restaurant)

        init {
            itemView.setOnClickListener(this);
            favourite.setOnClickListener(this);
        }

        override fun onClick(v: View?) {
            val position: Int = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                if (v?.id == favourite.id) {

                } else {
                    //listener.onItemClick(position)
                }
            }
        }
    }

   // override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantListHolder {
        // val itemView = LayoutInflater.from(parent.context).inflate(R.layout.)
     //   return
    //}

    override fun onBindViewHolder(holder: RestaurantListHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}

 */