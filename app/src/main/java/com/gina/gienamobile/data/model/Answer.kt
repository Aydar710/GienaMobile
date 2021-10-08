package com.gina.gienamobile.data.model

import com.google.gson.annotations.SerializedName

data class Answer(
    @SerializedName("id")
    val id: Number,
    @SerializedName("text")
    val answerText: String,
    @SerializedName("money_qty")
    val moneyQty: Number,
    @SerializedName("reply")
    val reply: String
)