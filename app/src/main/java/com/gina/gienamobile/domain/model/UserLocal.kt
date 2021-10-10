package com.gina.gienamobile.domain.model

data class UserLocal(
    var daysBeforePayday: Int,
    val eventsQty: Int,
    val moneyQty: Int,
    val id: Int,
    val questionsQty: Int
)
