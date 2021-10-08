package com.gina.gienamobile.data.model

import com.google.gson.annotations.SerializedName

data class Answer(
    @SerializedName("ID")
    val id: String,
    @SerializedName("AnswerText")
    val answerText: String,
    @SerializedName("MoneyQTY")
    val moneyQty: Number
)