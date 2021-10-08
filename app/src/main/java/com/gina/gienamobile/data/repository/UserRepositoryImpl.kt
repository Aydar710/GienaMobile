package com.gina.gienamobile.data.repository

import com.gina.gienamobile.data.model.User

class UserRepositoryImpl() : UserRepository {
    override suspend fun getUserById(id: String): Result<User> {
        return Result.success(User("1", "Username", 27))
    }

    override suspend fun setUserInfo(user: User): Result<Unit> {
        return Result.success(Unit)
    }

}