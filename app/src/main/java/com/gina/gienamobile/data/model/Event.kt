package com.gina.gienamobile.data.model

import com.google.gson.annotations.SerializedName

data class Event(
    @SerializedName("id")
    override val id: Number,
    @SerializedName("text")
    override val text: String,
    override val user : User,
    @SerializedName("money_qty")
    val moneyQty: Number
) : Card(id, text, user)