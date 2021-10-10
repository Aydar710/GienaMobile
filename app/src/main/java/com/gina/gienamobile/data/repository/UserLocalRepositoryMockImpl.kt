package com.gina.gienamobile.data.repository

import com.gina.gienamobile.data.model.User
import kotlin.properties.Delegates

class UserLocalRepositoryMockImpl : UserLocalRepository {

    private var currentUser = User(id = 79, daysBeforePayday = 3, eventsQty = 3, moneyQty = 1, questionsQty = 12)
    private lateinit var userName: String

    override var currentUserId by Delegates.notNull<Int>()

    override fun getCurrentUser(): User {
        return currentUser
    }

    override fun saveCurrentUser(user: User) {
        currentUser = user
    }

    override fun setUserName(name: String) {
        userName = name
    }

    override fun setuserId(id: Int) {
        currentUserId = id
    }
}