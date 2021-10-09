package com.gina.gienamobile.presentation.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gina.gienamobile.R
import com.gina.gienamobile.R.layout
import com.gina.gienamobile.domain.model.CardLocal
import com.gina.gienamobile.presentation.main.CardStackAdapter.ViewHolder

class CardStackAdapter(
    private var spots: MutableList<CardLocal> = mutableListOf()
) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(layout.item_event, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(spots[position])
    }

    override fun getItemCount(): Int {
        return spots.size
    }

    fun setSpots(spots: List<CardLocal>) {
        this.spots = spots.toMutableList()
    }

    fun getSpots(): List<CardLocal> {
        return spots
    }

    fun addEvent(event: CardLocal) {
        spots.add(event)
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        //        val name: TextView = view.findViewById(R.id.item_text)
        /*var city: TextView = view.findViewById(R.id.item_city)
        var image: ImageView = view.findViewById(R.id.item_image)*/
        val cardsToSalary = view.findViewById<TextView>(R.id.tvCardsToSalary)

        fun bind(cardLocal: CardLocal) {
//            name.text = cardLocal.text
            /*Glide.with(holder.image)
                    .load(spot.url)
                    .into(holder.image)*/
            itemView.setOnClickListener { v ->
            }

            /*val text = itemView.context.resources.getQuantityString(
                R.plurals.cards_to_salary,
                cardLocal..daysBeforePayday,
                cardLocal.user.daysBeforePayday
            )*/
//            cardsToSalary.text = text
        }
    }
}
