package com.gina.gienamobile.presentation.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gina.gienamobile.R
import com.gina.gienamobile.R.layout
import com.gina.gienamobile.domain.model.BaseCardLocal
import com.gina.gienamobile.domain.model.EventCardLocal
import com.gina.gienamobile.domain.model.QuestionCardLocal
import com.gina.gienamobile.domain.model.UserLocal
import com.gina.gienamobile.presentation.main.CardStackAdapter.ViewHolder

class CardStackAdapter(
    private var spots: MutableList<BaseCardLocal> = mutableListOf()
) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(layout.item_event, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(spots.last())
    }

    override fun getItemCount(): Int {
        return spots.size
    }

    fun setSpots(spots: List<BaseCardLocal>) {
        this.spots = spots.toMutableList()
    }

    fun getSpots(): List<BaseCardLocal> {
        return spots
    }

    fun addEvent(event: BaseCardLocal) {
        spots.add(event)
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val cardsToSalary = view.findViewById<TextView>(R.id.tvCardsToSalary)
        val tvEvent = view.findViewById<TextView>(R.id.tvEvent)

        fun bind(cardLocal: BaseCardLocal) {
            when (cardLocal) {
                is QuestionCardLocal -> {
                    setDaysBeforeSalary(cardLocal.user)
                    tvEvent.text = cardLocal.question.text
                }
                is EventCardLocal -> {
                    setDaysBeforeSalary(cardLocal.user)
                    tvEvent.text = cardLocal.event.text
                }
            }
        }

        private fun setDaysBeforeSalary(user: UserLocal) {
            val text = itemView.context.resources.getQuantityString(
                R.plurals.cards_to_salary,
                user.daysBeforePayday,
                user.daysBeforePayday
            )
            cardsToSalary.text = text
        }
    }
}
