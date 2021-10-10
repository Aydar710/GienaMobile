package com.gina.gienamobile.presentation.endgame

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gina.gienamobile.domain.interactors.SendUserOpenedLinkAnalyticsEvent
import kotlinx.coroutines.launch

class EndGameViewModel(private val sendUserOpenedLinkAnalyticsEvent: SendUserOpenedLinkAnalyticsEvent) : ViewModel() {

    fun userOpenedLink(link: String) = viewModelScope.launch {
        sendUserOpenedLinkAnalyticsEvent.invoke(link)
    }
}