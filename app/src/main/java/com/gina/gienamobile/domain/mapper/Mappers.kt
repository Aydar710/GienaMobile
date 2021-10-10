package com.gina.gienamobile.domain.mapper

import com.gina.gienamobile.data.model.Answer
import com.gina.gienamobile.data.model.BaseCardResponse
import com.gina.gienamobile.data.model.Event
import com.gina.gienamobile.data.model.EventResponse
import com.gina.gienamobile.data.model.Question
import com.gina.gienamobile.data.model.QuestionResponse
import com.gina.gienamobile.data.model.User
import com.gina.gienamobile.domain.excpetions.NotSupportedEventException
import com.gina.gienamobile.domain.model.AnswerLocal
import com.gina.gienamobile.domain.model.BaseCardLocal
import com.gina.gienamobile.domain.model.EventCardLocal
import com.gina.gienamobile.domain.model.EventLocal
import com.gina.gienamobile.domain.model.QuestionCardLocal
import com.gina.gienamobile.domain.model.QuestionLocal
import com.gina.gienamobile.domain.model.UserLocal

fun Answer.toAnswerLocal(): AnswerLocal =
    AnswerLocal(
        id = id,
        answerText = answerText,
        moneyQty = moneyQty,
        reply = reply,
        link = link
    )

fun Event.toEventLocal(): EventLocal =
    EventLocal(
        id = id,
        text = text,
        moneyQty = moneyQty
    )

fun QuestionResponse.toQuestionCardLocal(): QuestionCardLocal =
    QuestionCardLocal(
        question = question.toQuestionLocal(),
        user = user.toUserLocal()
    )

fun EventResponse.toEventCardLocal(): EventCardLocal =
    EventCardLocal(
        event = event.toEventLocal(),
        user = user.toUserLocal()
    )

fun Question.toQuestionLocal(): QuestionLocal =
    QuestionLocal(
        negativeDecisionAnswer = negativeDecisionAnswer,
        positiveDecisionAnswer = positiveDecisionAnswer,
        text = text,
        warnAboutWrongDecision = warnAboutWrongDecision,
        warningText = warningText
    )

fun BaseCardResponse.toBaseCardLocal(): BaseCardLocal {
    return when (this) {
        is QuestionResponse -> toQuestionCardLocal()
        is EventResponse -> toEventCardLocal()
        else -> throw NotSupportedEventException(this)
    }
}

fun User.toUserLocal(): UserLocal =
    UserLocal(
        daysBeforePayday = daysBeforePayday,
        eventsQty = eventsQty,
        moneyQty = moneyQty,
        id = id,
        questionsQty = questionsQty
    )