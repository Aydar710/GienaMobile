package com.gina.gienamobile.data.model

import com.google.gson.annotations.SerializedName

data class Event(
    @SerializedName("ID")
    val id: String,
    @SerializedName("EventText")
    val eventText: String,
    @SerializedName("MoneyQTY")
    val moneyQty: Number,
)