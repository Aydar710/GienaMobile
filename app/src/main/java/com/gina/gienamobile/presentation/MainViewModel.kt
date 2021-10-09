package com.gina.gienamobile.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gina.gienamobile.domain.GetCardInteractor
import com.gina.gienamobile.domain.model.CardLocal
import com.gina.gienamobile.presentation.utils.SingleLiveEvent
import kotlinx.coroutines.launch

class MainViewModel(private val getCardInteractor: GetCardInteractor) : ViewModel() {

    val currentCard = SingleLiveEvent<CardLocal>()

    fun requestEvent() = viewModelScope.launch {
        val cardLocal = getCardInteractor.invoke()
        cardLocal.getOrNull()?.let {
            currentCard.postValue(it)
        }
    }
}
