package com.gina.gienamobile.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.gina.gienamobile.R

class CardStackAdapter(
        private var spots: MutableList<Event> = mutableListOf()
) : RecyclerView.Adapter<CardStackAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.item_event, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val spot = spots[position]
        holder.name.text = "${spot.text}. ${spot.text}"
        /*Glide.with(holder.image)
                .load(spot.url)
                .into(holder.image)*/
        holder.itemView.setOnClickListener { v ->
            Toast.makeText(v.context, spot.text, Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return spots.size
    }

    fun setSpots(spots: List<Event>) {
        this.spots = spots as MutableList<Event>
    }

    fun getSpots(): List<Event> {
        return spots
    }

    fun addEvent(event : Event){
        spots.add(event)
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.item_text)
        /*var city: TextView = view.findViewById(R.id.item_city)
        var image: ImageView = view.findViewById(R.id.item_image)*/
    }

}
