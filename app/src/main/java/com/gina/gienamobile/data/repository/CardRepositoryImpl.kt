package com.gina.gienamobile.data.repository

import com.gina.gienamobile.data.model.BaseCardResponse
import com.gina.gienamobile.data.service.GienaService

class CardRepositoryImpl(private val service: GienaService, private val userLocalRepository: UserLocalRepository) : CardRepository {

    override suspend fun getCard(userId: Int): BaseCardResponse? {
        val response = service.getCard(userLocalRepository.currentUserId)
        return response.body()?.baseCardResponse
    }
}