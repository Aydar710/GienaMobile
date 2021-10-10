package com.gina.gienamobile.data.repository

import com.gina.gienamobile.data.model.Answer
import com.gina.gienamobile.data.model.BaseCardResponse
import com.gina.gienamobile.data.model.Question
import com.gina.gienamobile.data.model.QuestionResponse
import com.gina.gienamobile.data.model.User
import kotlin.random.Random

class CardRepositoryMockImpl : CardRepository {

    override suspend fun getCard(userId: Int): BaseCardResponse {
        val negativeDecisionAnswer = Answer(1, "Негативный ответ", 123, "Reply negative")
        val positiveDecisionAnswer = Answer(1, "Позитивный ответ", -123, "Reply positive")
        val user = User(daysBeforePayday = 3, eventsQty = 3, moneyQty = 1, id = 1, questionsQty = 12)

        val questionTexts = listOf(
            "Путешествия во времени возможны, хотя бы теоретически?",
            "Что делать, если Земля перестанет вращаться?",
            "Сколько всего денег в мире?"
        )

        val warningTexts = listOf("Warning text 1", "Warning text 2")
        val question = Question(
            negativeDecisionAnswer = negativeDecisionAnswer,
            positiveDecisionAnswer = positiveDecisionAnswer,
            text = questionTexts.random(),
            warnAboutWrongDecision = Random.nextBoolean(),
            warningText = warningTexts.random()
        )
        return QuestionResponse(
            question = question,
            user = user
        )
    }
}
