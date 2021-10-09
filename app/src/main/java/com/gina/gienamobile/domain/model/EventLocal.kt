package com.gina.gienamobile.domain.model

data class EventLocal(
    override val id: Number,
    override val text: String,
    val moneyQty: Number
) : CardLocal(id, text)
