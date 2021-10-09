package com.gina.gienamobile.domain.excpetions

import com.gina.gienamobile.data.model.BaseCardResponse

class NotSupportedEventException(private val baseCardResponse: BaseCardResponse) : Exception() {

    override val message: String
        get() = "Not supported event - $baseCardResponse"
}