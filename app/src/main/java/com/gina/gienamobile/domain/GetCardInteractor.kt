package com.gina.gienamobile.domain

import com.gina.gienamobile.data.repository.CardRepository
import com.gina.gienamobile.data.repository.UserLocalRepository
import com.gina.gienamobile.domain.mapper.toBaseCardLocal
import com.gina.gienamobile.domain.model.BaseCardLocal
import kotlin.Result.Companion

class GetCardInteractor(
    private val cardRepository: CardRepository,
    private val userLocalRepository: UserLocalRepository
) {

    suspend operator fun invoke(): Result<BaseCardLocal?> {
        val currentUser = userLocalRepository.getCurrentUser()
        val cardResult = cardRepository.getCard(currentUser.id)
        cardResult.getOrNull()?.let { card ->
            return Companion.success(card.toBaseCardLocal())
        } ?: return Companion.failure(Exception("Not supported Event"))
    }
}
