package com.gina.gienamobile.data.model
import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("ID")
    val id: String,
    @SerializedName("Name")
    val name: String,
    @SerializedName("Old")
    val old: Number
)