package com.gina.gienamobile.data.model

import com.gina.gienamobile.data.BaseCardResponseTypeAdapter
import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName

data class CardResponseWrapper(
    @SerializedName("type")
    val type: String,
    @SerializedName("object")
    @JsonAdapter(BaseCardResponseTypeAdapter::class)
    val baseCardResponse: BaseCardResponse
)