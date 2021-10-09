package com.gina.gienamobile.domain.model

data class EventLocal(
    val id: Int,
    val moneyQty: Int,
    override val text: String
) : CardLocal(text)