package com.gina.gienamobile.data.model

import com.google.gson.annotations.SerializedName

data class QuestionResponse(
    @SerializedName("question")
    val question: Question,
    @SerializedName("user")
    val user: User
) : BaseCardResponse()
