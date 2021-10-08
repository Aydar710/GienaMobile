package com.gina.gienamobile.data.model

import com.google.gson.annotations.SerializedName

data class Question(
    @SerializedName("ID")
    val id: String,
    @SerializedName("Text")
    val text: String,
    @SerializedName("NegativeAnswer")
    val negativeDecisionAnswer: Answer,
    @SerializedName("PositiveAnswer")
    val positiveDecisionAnswer: Answer
)