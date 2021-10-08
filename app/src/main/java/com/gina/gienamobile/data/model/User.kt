package com.gina.gienamobile.data.model

import com.gina.gienamobile.data.enums.Roles
import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("id")
    val id: Number,
    @SerializedName("username")
    val username: String,
    @SerializedName("money_qty")
    val moneyQty: Number,
    @SerializedName("role")
    val role: Roles,
    @SerializedName("questions")
    val questions: List<Question>? = null,
    @SerializedName("events")
    val events: List<Event>? = null
)