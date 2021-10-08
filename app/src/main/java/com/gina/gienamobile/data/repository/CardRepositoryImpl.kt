package com.gina.gienamobile.data.repository

import com.gina.gienamobile.data.model.Card

class CardRepositoryImpl() : CardRepository {
    override suspend fun getCard(): Result<Card> {
        TODO("Not yet implemented")
        return Result.success(Card(0, "Card text"))
    }

}