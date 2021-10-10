package com.gina.gienamobile.data.repository

import com.gina.gienamobile.data.model.User

interface UserLocalRepository {

    var currentUserId : Int

    fun getCurrentUser(): User

    fun saveCurrentUser(user: User)

    fun setUserName(name: String)
    fun setuserId(id: Int)
}