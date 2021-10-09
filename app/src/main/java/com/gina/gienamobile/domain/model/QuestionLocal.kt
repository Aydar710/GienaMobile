package com.gina.gienamobile.domain.model

data class QuestionLocal(
    override val id: Number,
    override val text: String,
    val negativeDecisionAnswer: AnswerLocal,
    val positiveDecisionAnswer: AnswerLocal
) : CardLocal(id, text)
