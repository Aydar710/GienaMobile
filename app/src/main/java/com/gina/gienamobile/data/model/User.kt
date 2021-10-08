package com.gina.gienamobile.data.model

import com.gina.gienamobile.data.enums.Roles
import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("ID")
    val id: String,
    @SerializedName("Username")
    val username: String,
    @SerializedName("moneyQty")
    val moneyQty: Number,
    @SerializedName("Role")
    val role: Roles,
    @SerializedName("Questions")
    val questions: List<Question>? = null,
    @SerializedName("Events")
    val events: List<Event>? = null
)