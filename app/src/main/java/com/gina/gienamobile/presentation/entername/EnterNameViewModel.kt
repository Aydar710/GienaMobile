package com.gina.gienamobile.presentation.entername

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gina.gienamobile.data.repository.UserLocalRepository
import com.gina.gienamobile.data.repository.UserRepository
import com.gina.gienamobile.presentation.utils.SingleLiveEvent
import kotlinx.coroutines.launch

class EnterNameViewModel(
    private val userLocalRepository: UserLocalRepository,
    private val userRepository: UserRepository
) : ViewModel() {

    val openSelectClassActivity = SingleLiveEvent<Unit>()

    fun onStartClicked(name: String) = viewModelScope.launch {
        userLocalRepository.setUserName(name)
        userRepository.register(name)
        openSelectClassActivity.postValue(Unit)
    }
}