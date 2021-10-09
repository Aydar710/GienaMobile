package com.gina.gienamobile.data.model

import com.google.gson.annotations.SerializedName

abstract class Card(
    @SerializedName("id")
    open val id: Number,
    @SerializedName("text")
    open val text: String,
    open val user : User
)
