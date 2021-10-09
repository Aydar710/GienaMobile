package com.gina.gienamobile.data.repository

import com.gina.gienamobile.data.model.Answer
import com.gina.gienamobile.data.model.Card
import com.gina.gienamobile.data.model.Question

class CardRepositoryImpl : CardRepository {

    override suspend fun getCard(userId: Int): Result<Card> {
        val negativeDecisionAnswer = Answer(1, "Негативный ответ", 123, "Reply negative")
        val positiveDecisionAnswer = Answer(1, "Позитивный ответ", -123, "Reply positive")
        return Result.success(Question(0, "Card text", negativeDecisionAnswer, positiveDecisionAnswer))
    }
}
