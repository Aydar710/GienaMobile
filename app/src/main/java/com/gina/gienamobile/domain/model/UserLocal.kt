package com.gina.gienamobile.domain.model

import com.gina.gienamobile.data.enums.Roles

data class UserLocal(
    val id: Int,
    val username: String,
    val moneyQty: Int,
    val role: Roles,
    val questions: List<QuestionLocal>? = null,
    val events: List<EventLocal>? = null,
    val cardToSalary: Int
)
