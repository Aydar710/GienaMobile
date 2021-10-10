package com.gina.gienamobile.data.repository

import com.gina.gienamobile.data.model.User

interface UserRepository {
    suspend fun getUserById(id: String): Result<User>
    suspend fun setUserInfo(user: User): Result<Unit>
    suspend fun register(name: String)
}