package com.gina.gienamobile.data.model

import com.google.gson.annotations.SerializedName

data class Question(
    @SerializedName("negative_decision_answer")
    val negativeDecisionAnswer: Answer,
    @SerializedName("positive_decision_answer")
    val positiveDecisionAnswer: Answer,
    @SerializedName("text")
    val text: String,
    @SerializedName("warn_about_wrong_decision")
    val warnAboutWrongDecision: Boolean,
    @SerializedName("warning_text")
    val warningText: String? = null
)
