package com.gina.gienamobile.data.model

import com.google.gson.annotations.SerializedName

data class Event(
    @SerializedName("id")
    val id: Int,
    @SerializedName("money_qty")
    val moneyQty: Int,
    @SerializedName("text")
    override val text: String
) : Card(text)