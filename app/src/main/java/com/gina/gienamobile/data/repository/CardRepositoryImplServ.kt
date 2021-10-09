package com.gina.gienamobile.data.repository

import com.gina.gienamobile.data.model.BaseCardResponse
import com.gina.gienamobile.data.service.GienaService

class CardRepositoryImplServ(private val service: GienaService) : CardRepository {

    override suspend fun getCard(userId: Int): Result<BaseCardResponse> {
        try {
            val response = service.getCard(34)
            val baseCardResponse = response.body()?.baseCardResponse
        } catch (e: Exception) {
            println()
        }
        val response = service.getCard(userId)
        val baseCardResponse = response.body()?.baseCardResponse
        return Result.success(baseCardResponse!!)
    }
}