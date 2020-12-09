package com.example.restaurants.data.restaurants

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurants.R



class RestaurantListAdapter:RecyclerView.Adapter<RestaurantListAdapter.RestaurantListViewHolder>() {

    private var list = emptyList<Restaurant>()
    inner class RestaurantListViewHolder(itemview: View):RecyclerView.ViewHolder(itemview)
    {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantListViewHolder {
       return RestaurantListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_example,parent,false))
    }

    override fun onBindViewHolder(holder: RestaurantListViewHolder, position: Int) {
       // holder.itemView.findViewById<ImageView>(R.id.image_restaurant).text = list[position].image_url.toString()
        holder.itemView.findViewById<TextView>(R.id.name_restaurant).text = list[position].name
        holder.itemView.findViewById<TextView>(R.id.Adress_restaurant).text = list[position].adress
        holder.itemView.findViewById<TextView>(R.id.phone_restaurant).text = list[position].phone_number


    }

    override fun getItemCount(): Int {
       return list.size
    }

    fun setData(newList:List<Restaurant>)
    {
        list = newList
        notifyDataSetChanged()

    }
}