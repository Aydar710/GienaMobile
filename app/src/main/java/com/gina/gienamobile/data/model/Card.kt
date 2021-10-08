package com.gina.gienamobile.data.model

import com.google.gson.annotations.SerializedName

open class Card(
    @SerializedName("id")
    open val id: Number,
    @SerializedName("text")
    open val text: String,
)
