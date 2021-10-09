package com.gina.gienamobile.data.model

import com.google.gson.annotations.SerializedName

data class EventResponse(
    @SerializedName("event")
    val event: Event,
    @SerializedName("user")
    val user: User
) : BaseCardResponse()
