package com.gina.gienamobile.data

import com.gina.gienamobile.data.model.BaseCardResponse
import com.gina.gienamobile.data.model.Event
import com.gina.gienamobile.data.model.EventResponse
import com.gina.gienamobile.data.model.Question
import com.gina.gienamobile.data.model.QuestionResponse
import com.gina.gienamobile.data.model.User
import com.google.gson.Gson
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

class BaseCardResponseTypeAdapter : JsonDeserializer<BaseCardResponse> {

    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): BaseCardResponse {
        val user = User(daysBeforePayday = 3, eventsQty = 3, moneyQty = 1, id = 1, questionsQty = 12)
        val isQuestion = json?.asJsonObject?.get("positive_decision_answer") != null

        return if (isQuestion) {
            val question = Gson().fromJson(json, Question::class.java)
            QuestionResponse(
                question = question,
                user = user
            )
        } else {
            val event = Gson().fromJson(json, Event::class.java)
            EventResponse(
                event = event,
                user = user
            )
        }
    }
}