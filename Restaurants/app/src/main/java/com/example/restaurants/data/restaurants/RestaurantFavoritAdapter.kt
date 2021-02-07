package com.example.restaurants.data.restaurants

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurants.R
import org.w3c.dom.Text

class RestaurantFavoritAdapter(
    private var restaurantList:MutableList<Restaurant>
): RecyclerView.Adapter<RestaurantFavoritAdapter.FavoritViewHolder>() {


    inner class FavoritViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    {
        val image = itemView.findViewById<ImageView>(R.id.favourite_image)
        val name = itemView.findViewById<TextView>(R.id.favourite_name)
        val adress = itemView.findViewById<TextView>(R.id.favourite_adress)

        init {

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantFavoritAdapter.FavoritViewHolder {
        return FavoritViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.favourite_item,parent,false))
    }


    override fun onBindViewHolder(holder: FavoritViewHolder, position: Int) {
       holder.name.text = restaurantList[position].name
        holder.adress.text = restaurantList[position].address

    }

    override fun getItemCount(): Int {
        return restaurantList.size
    }

}