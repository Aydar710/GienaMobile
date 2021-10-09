package com.gina.gienamobile.domain.model

data class EventCardLocal(
    val event: EventLocal,
    val user: UserLocal
) : BaseCardLocal()