package com.gina.gienamobile.data.repository

import com.gina.gienamobile.data.enums.Roles
import com.gina.gienamobile.data.model.User

class UserRepositoryImpl() : UserRepository {
    override suspend fun getUserById(id: String): Result<User> {
        return Result.success(User(0, "Username", 1000, Roles.STUDENT))
    }

    override suspend fun setUserInfo(user: User): Result<Unit> {
        return Result.success(Unit)
    }

}