package com.gina.gienamobile.data.repository

import com.gina.gienamobile.data.enums.Roles.STUDENT
import com.gina.gienamobile.data.model.Answer
import com.gina.gienamobile.data.model.Card
import com.gina.gienamobile.data.model.Question
import com.gina.gienamobile.data.model.User
import kotlin.random.Random

class CardRepositoryImpl : CardRepository {

    override suspend fun getCard(userId: Int): Result<Card> {
        val negativeDecisionAnswer = Answer(1, "Негативный ответ", 123, "Reply negative")
        val positiveDecisionAnswer = Answer(1, "Позитивный ответ", -123, "Reply positive")
        val user = User(id = 1, username = "Vatabe", Random.nextInt(1000), STUDENT, cardToSalary = 5)
        return Result.success(Question(0, "Card text", user, negativeDecisionAnswer, positiveDecisionAnswer))
    }
}
