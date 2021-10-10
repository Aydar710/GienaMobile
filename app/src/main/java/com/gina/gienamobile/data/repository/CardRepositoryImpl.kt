package com.gina.gienamobile.data.repository

import com.gina.gienamobile.data.model.BaseCardResponse
import com.gina.gienamobile.data.service.GienaService

class CardRepositoryImpl(private val service: GienaService) : CardRepository {

    override suspend fun getCard(userId: Int): BaseCardResponse? {
        val response = service.getCard(67)
        return response.body()?.baseCardResponse
    }
}