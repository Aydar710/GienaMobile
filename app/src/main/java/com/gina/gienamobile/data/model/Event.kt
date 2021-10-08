package com.gina.gienamobile.data.model

import com.google.gson.annotations.SerializedName

data class Event(
    @SerializedName("ID")
    val id: String,
    @SerializedName("Name")
    val name: String,
    @SerializedName("Text")
    val text: String
)