package com.gina.gienamobile.presentation

import androidx.lifecycle.ViewModel
import com.gina.gienamobile.presentation.utils.SingleLiveEvent
import java.util.Date

class MainViewModel : ViewModel() {

    val currentCard = SingleLiveEvent<Event>()

    fun requestEvent() {
        val event = Event("text ${Date().time}")
        currentCard.postValue(event)
    }
}
