package com.gina.gienamobile.domain

import com.gina.gienamobile.data.model.Card
import com.gina.gienamobile.data.repository.CardRepository
import com.gina.gienamobile.data.repository.UserLocalRepository

class GetCardInteractor(
    private val cardRepository: CardRepository,
    private val userLocalRepository: UserLocalRepository
) {

    suspend operator fun invoke(): Result<Card> {
        val currentUser = userLocalRepository.getCurrentUser()
        return cardRepository.getCard(currentUser.id)
    }
}