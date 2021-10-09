package com.gina.gienamobile.data.repository
import com.gina.gienamobile.data.model.BaseCardResponse

interface CardRepository {

    suspend fun getCard(userId: Int): Result<BaseCardResponse>
}