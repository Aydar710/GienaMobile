package com.gina.gienamobile.domain.interactors

import com.gina.gienamobile.data.repository.CardRepository
import com.gina.gienamobile.data.repository.UserLocalRepository
import com.gina.gienamobile.domain.mapper.toBaseCardLocal
import com.gina.gienamobile.domain.model.BaseCardLocal

class GetCardInteractor(
    private val cardRepository: CardRepository,
    private val userLocalRepository: UserLocalRepository
) {

    suspend operator fun invoke(): BaseCardLocal? {
        val currentUser = userLocalRepository.getCurrentUser()
        val cardResult = cardRepository.getCard(currentUser.id)
        return cardResult?.toBaseCardLocal()
    }
}
