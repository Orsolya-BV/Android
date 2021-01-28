package com.example.restaurants.data.restaurants

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.restaurants.R
import com.example.restaurants.fragments.ListFragment

class RestaurantAdapter(
    private var restaurantList:MutableList<Restaurant>
    ) :RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder>(){



    inner class RestaurantViewHolder(itemView: View):RecyclerView.ViewHolder(itemView),View.OnClickListener
    {
        var name: TextView = itemView.findViewById(R.id.name_restaurant)
        val adress: TextView = itemView.findViewById(R.id.Adress_restaurant)
        val phone: TextView = itemView.findViewById(R.id.phone_restaurant)
        val favourite: ImageView = itemView.findViewById(R.id.favorit_restaurant)

        init {
            itemView.setOnClickListener(this)
            favourite.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            val position = adapterPosition
            if (v != null)
            {
                if(position != RecyclerView.NO_POSITION)
                {
                    if(v.id == favourite.id)
                    {
                       // listener.onItemClick(parent,v,position,id)
                    }else
                    {
                        //listener.onItemClick(position)
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
       return RestaurantViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_example,parent,false))

    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        holder.name.text = restaurantList[position].name.toString()
        holder.adress.text = restaurantList[position].address
        holder.phone.text = restaurantList[position].phone


    }

    override fun getItemCount(): Int {
        return restaurantList.size
    }


}