package com.gina.gienamobile.data.model

import com.google.gson.annotations.SerializedName

abstract class Card(
    @SerializedName("text")
    open val text: String
)
