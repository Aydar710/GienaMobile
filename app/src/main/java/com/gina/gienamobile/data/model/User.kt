package com.gina.gienamobile.data.model
import com.gina.gienamobile.data.enums.Roles
import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("ID")
    val id: String,
    @SerializedName("Username")
    val username: String,
    @SerializedName("Role")
    val role: Roles
)