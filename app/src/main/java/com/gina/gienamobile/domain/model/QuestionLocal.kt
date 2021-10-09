package com.gina.gienamobile.domain.model

import com.gina.gienamobile.data.model.Answer

data class QuestionLocal(
    val negativeDecisionAnswer: Answer,
    val positiveDecisionAnswer: Answer,
    override val text: String,
    val warnAboutWrongDecision: Boolean,
    val warningText: String? = null
) : CardLocal(text)
