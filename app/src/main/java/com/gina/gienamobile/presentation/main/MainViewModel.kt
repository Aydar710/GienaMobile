package com.gina.gienamobile.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gina.gienamobile.domain.GetCardInteractor
import com.gina.gienamobile.domain.model.EventCardLocal
import com.gina.gienamobile.domain.model.QuestionCardLocal
import com.gina.gienamobile.presentation.utils.SingleLiveEvent
import kotlinx.coroutines.launch

class MainViewModel(private val getCardInteractor: GetCardInteractor) : ViewModel() {

    val currentQuestion = SingleLiveEvent<QuestionCardLocal>()
    val currentEvent = SingleLiveEvent<EventCardLocal>()

    fun requestEvent() = viewModelScope.launch {
        val cardLocal = getCardInteractor.invoke()
        cardLocal?.let {
            when (it) {
                is QuestionCardLocal -> {
                    currentQuestion.postValue(it)
                }
                is EventCardLocal -> {
                    currentEvent.postValue(it)
                }
            }
        }
    }
}
