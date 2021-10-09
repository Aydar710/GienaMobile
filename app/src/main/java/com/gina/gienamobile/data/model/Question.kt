package com.gina.gienamobile.data.model

import com.google.gson.annotations.SerializedName

data class Question(
    @SerializedName("id")
    override val id: Number,
    @SerializedName("text")
    override val text: String,
    override val user: User,
    @SerializedName("negative_decision_answer")
    val negativeDecisionAnswer: Answer,
    @SerializedName("positive_decision_answer")
    val positiveDecisionAnswer: Answer
) : Card(id, text, user)