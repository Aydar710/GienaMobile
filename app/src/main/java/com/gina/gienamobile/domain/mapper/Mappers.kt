package com.gina.gienamobile.domain.mapper

import com.gina.gienamobile.data.model.Answer
import com.gina.gienamobile.data.model.Card
import com.gina.gienamobile.data.model.Event
import com.gina.gienamobile.data.model.Question
import com.gina.gienamobile.data.model.User
import com.gina.gienamobile.domain.excpetions.NotSupportedEventException
import com.gina.gienamobile.domain.model.AnswerLocal
import com.gina.gienamobile.domain.model.CardLocal
import com.gina.gienamobile.domain.model.EventLocal
import com.gina.gienamobile.domain.model.QuestionLocal
import com.gina.gienamobile.domain.model.UserLocal

fun Answer.toAnswerLocal(): AnswerLocal =
    AnswerLocal(
        id = id,
        answerText = answerText,
        moneyQty = moneyQty,
        reply = reply
    )

fun Event.toEventLocal(): EventLocal =
    EventLocal(
        id = id,
        text = text,
        moneyQty = moneyQty,
        user = user.toUserLocal()
    )

fun Question.toQuestionLocal(): QuestionLocal =
    QuestionLocal(
        id = id,
        text = text,
        negativeDecisionAnswer = negativeDecisionAnswer.toAnswerLocal(),
        positiveDecisionAnswer = positiveDecisionAnswer.toAnswerLocal(),
        user = user.toUserLocal()
    )

fun Card.toCardLocal(): CardLocal {
    return when (this) {
        is Question -> toQuestionLocal()
        is Event -> toEventLocal()
        else -> throw NotSupportedEventException(this)
    }
}

fun User.toUserLocal(): UserLocal =
    UserLocal(
        id = id,
        username = username,
        moneyQty = moneyQty,
        role = role,
        questions = questions?.map { it.toQuestionLocal() },
        events = events?.map { it.toEventLocal() },
        cardToSalary = cardToSalary
    )