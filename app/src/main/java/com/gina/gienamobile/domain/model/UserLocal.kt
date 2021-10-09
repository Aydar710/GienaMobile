package com.gina.gienamobile.domain.model

data class UserLocal(
    val daysBeforePayday: Int,
    val eventsQty: Int,
    val moneyQty: Int,
    val id: Int,
    val questionsQty: Int
)
