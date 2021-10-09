package com.gina.gienamobile.data.repository

import com.gina.gienamobile.data.model.User

class UserRepositoryImpl() : UserRepository {

    override suspend fun getUserById(id: String): Result<User> {
        return Result.success(User(daysBeforePayday = 3, eventsQty = 3, moneyQty = 1, id = 1, questionsQty = 12))
    }

    override suspend fun setUserInfo(user: User): Result<Unit> {
        return Result.success(Unit)
    }
}