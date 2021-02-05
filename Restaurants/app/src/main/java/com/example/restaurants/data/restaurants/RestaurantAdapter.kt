package com.example.restaurants.data.restaurants

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.replace
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.restaurants.R
import com.example.restaurants.fragments.DetailsFragment
import com.example.restaurants.fragments.ListFragment

class RestaurantAdapter(
    private var restaurantList:MutableList<Restaurant>,
    private var listener: OnItemClickListener
    ) :RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder>(),Filterable{

    var filteredList = restaurantList

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
            if (position != RecyclerView.NO_POSITION){
                listener.onItemClick(position)
            }
        }


    }

    interface OnItemClickListener
    {
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
       return RestaurantViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_example,parent,false))

    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        holder.name.text = filteredList[position].name.toString()
        holder.adress.text = filteredList[position].address
        holder.phone.text = filteredList[position].phone

    }

    override fun getItemCount(): Int {
        //return restaurantList.size
        return filteredList.size
    }

    override fun getFilter(): Filter {
        return object:Filter()
        {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                val filterResults = FilterResults()
                if(charSearch.isEmpty())
                {
                    filteredList = restaurantList

                }
                else
                {
                    filteredList = restaurantList.filter { item ->
                        item.city.toUpperCase().contains(charSearch.toUpperCase())

                    }.toMutableList()

                }
                filterResults.values = filteredList
                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filteredList = results?.values as MutableList<Restaurant>
                notifyDataSetChanged()
            }

        }
    }


}