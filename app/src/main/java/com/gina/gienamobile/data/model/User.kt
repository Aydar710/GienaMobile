package com.gina.gienamobile.data.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("days_before_payday")
    val daysBeforePayday: Int,
    @SerializedName("events_qty")
    val eventsQty: Int,
    @SerializedName("money_qty")
    val moneyQty: Int,
    @SerializedName("pk")
    val id: Int,
    @SerializedName("questions_qty")
    val questionsQty: Int
)