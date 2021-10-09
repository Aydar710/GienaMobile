package com.gina.gienamobile.data.repository

import com.gina.gienamobile.data.model.User

class UserLocalRepositoryMockImpl : UserLocalRepository {

    override fun getCurrentUser(): User {
        return User(daysBeforePayday = 3, eventsQty = 3, moneyQty = 1, id = 1, questionsQty = 12)
    }
}