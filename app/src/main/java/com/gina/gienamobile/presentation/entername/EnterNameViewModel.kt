package com.gina.gienamobile.presentation.entername

import androidx.lifecycle.ViewModel
import com.gina.gienamobile.data.repository.UserLocalRepository
import com.gina.gienamobile.presentation.utils.SingleLiveEvent

class EnterNameViewModel(private val userLocalRepository: UserLocalRepository) : ViewModel() {

    val openSelectClassActivity = SingleLiveEvent<Unit>()

    fun onStartClicked(name: String) {
        userLocalRepository.setUserName(name)
        openSelectClassActivity.postValue(Unit)
    }
}