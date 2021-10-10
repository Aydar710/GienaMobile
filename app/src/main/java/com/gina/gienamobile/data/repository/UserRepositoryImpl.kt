package com.gina.gienamobile.data.repository

import com.gina.gienamobile.data.makeApiCall
import com.gina.gienamobile.data.model.User
import com.gina.gienamobile.data.service.GienaService
import com.gina.gienamobile.data.service.RegisterUserBody
import java.util.Date

class UserRepositoryImpl(private val service: GienaService, private val userLocalRepository: UserLocalRepository) :
    UserRepository {

    override suspend fun getUserById(id: String): Result<User> {
        return Result.success(User(daysBeforePayday = 3, eventsQty = 3, moneyQty = 1, id = 1, questionsQty = 12))
    }

    override suspend fun setUserInfo(user: User): Result<Unit> {
        return Result.success(Unit)
    }

    override suspend fun register(name: String) {
        val body = RegisterUserBody(first_name = Date().time.toString(), role = "student")
        val result = makeApiCall { service.registerUser(body) }
        result.getOrNull()?.let {
            userLocalRepository.currentUserId = it.id
        }
    }
}