package com.gina.gienamobile.data.repository

import com.gina.gienamobile.data.enums.Roles.STUDENT
import com.gina.gienamobile.data.model.User

class UserLocalRepositoryMockImpl : UserLocalRepository {

    override fun getCurrentUser(): User {
        return User(id = 1, username = "Vatabe", 123, STUDENT)
    }
}