package com.gina.gienamobile.domain.excpetions

import com.gina.gienamobile.data.model.Card

class NotSupportedEventException(private val card: Card) : Exception() {

    override val message: String
        get() = "Not supported event - $card"
}