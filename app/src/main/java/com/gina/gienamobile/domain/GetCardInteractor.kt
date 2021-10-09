package com.gina.gienamobile.domain

import com.gina.gienamobile.data.repository.CardRepository
import com.gina.gienamobile.data.repository.UserLocalRepository
import com.gina.gienamobile.domain.mapper.toCardLocal
import com.gina.gienamobile.domain.model.CardLocal
import kotlin.Result.Companion

class GetCardInteractor(
    private val cardRepository: CardRepository,
    private val userLocalRepository: UserLocalRepository
) {

    suspend operator fun invoke(): Result<CardLocal?> {
        val currentUser = userLocalRepository.getCurrentUser()
        val cardResult = cardRepository.getCard(currentUser.id)
        cardResult.getOrNull()?.let { card ->
            return Companion.success(card.toCardLocal())
        } ?: return Companion.failure(Exception("Not supported Event"))
    }
}
