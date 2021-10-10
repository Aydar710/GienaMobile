package com.gina.gienamobile.domain.interactors

import com.gina.gienamobile.data.repository.AnalyticsRepository
import com.gina.gienamobile.data.repository.UserLocalRepository

class SendUserOpenedLinkAnalyticsEvent(
    private val userRepository: UserLocalRepository,
    private val analyticsRepository: AnalyticsRepository
) {

    suspend operator fun invoke(link: String) {
        val currentUser = userRepository.getCurrentUser()
        analyticsRepository.sendUserOpenedLink(currentUser.id, link)
    }
}