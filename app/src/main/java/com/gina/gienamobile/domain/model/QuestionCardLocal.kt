package com.gina.gienamobile.domain.model

data class QuestionCardLocal(
    val question: QuestionLocal,
    val user: UserLocal
) : BaseCardLocal()