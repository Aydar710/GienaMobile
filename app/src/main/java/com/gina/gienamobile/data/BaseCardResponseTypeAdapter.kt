package com.gina.gienamobile.data

import com.gina.gienamobile.data.model.Answer
import com.gina.gienamobile.data.model.BaseCardResponse
import com.gina.gienamobile.data.model.Question
import com.gina.gienamobile.data.model.QuestionResponse
import com.gina.gienamobile.data.model.User
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type
import kotlin.random.Random

class BaseCardResponseTypeAdapter : JsonDeserializer<BaseCardResponse> {

    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): BaseCardResponse {
        /*val currencies = mutableListOf<ExchangeRate>()
        json?.asJsonObject?.let { jsonObject ->
            jsonObject
                .entrySet()
                .map {
                    it.value.asJsonObject
                }
                .forEach { currencyJsonObject ->
                    currencies.add(
                        ExchangeRate(
                            id = currencyJsonObject["ID"].asString,
                            numCode = currencyJsonObject["NumCode"].asInt,
                            charCode = currencyJsonObject["CharCode"].asString,
                            nominal = currencyJsonObject["Nominal"].asInt,
                            name = currencyJsonObject["Name"].asString,
                            value = currencyJsonObject["Value"].asDouble
                        )
                    )
                }
        }
        return currencies*/

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