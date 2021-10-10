package com.gina.gienamobile.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gina.gienamobile.domain.interactors.GetCardInteractor
import com.gina.gienamobile.domain.model.EventCardLocal
import com.gina.gienamobile.domain.model.QuestionCardLocal
import com.gina.gienamobile.presentation.utils.SingleLiveEvent
import kotlinx.coroutines.launch

class MainViewModel(private val getCardInteractor: GetCardInteractor) : ViewModel() {

    val currentQuestion = SingleLiveEvent<QuestionCardLocal>()
    val currentEvent = SingleLiveEvent<EventCardLocal>()
    val openEnding = SingleLiveEvent<Unit>()
    private var leftCardsToSalary = 4

    fun requestEvent() = viewModelScope.launch {
        leftCardsToSalary--
        if (leftCardsToSalary == 0) {
            leftCardsToSalary = 4
        }
        val cardLocal = getCardInteractor.invoke()
        cardLocal?.let {
            when (it) {
                is QuestionCardLocal -> {
                    it.user.daysBeforePayday = leftCardsToSalary
                    currentQuestion.postValue(it)
                }
                is EventCardLocal -> {
                    it.user.daysBeforePayday = leftCardsToSalary
                    currentEvent.postValue(it)
                }
            }
        } ?: openEnding.postValue(Unit)
    }
}
