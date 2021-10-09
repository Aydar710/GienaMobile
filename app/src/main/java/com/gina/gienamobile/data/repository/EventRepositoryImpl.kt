package com.gina.gienamobile.data.repository

import com.gina.gienamobile.data.enums.Roles.STUDENT
import com.gina.gienamobile.data.model.Event
import com.gina.gienamobile.data.model.User

class EventRepositoryImpl() : EventRepository {

    override suspend fun getEvents(): Result<List<Event>> {
        return Result.success(listOf())
    }

    override suspend fun getEventById(id: String): Result<Event> {
        val user = User(id = 1, username = "Vatabe", 123, STUDENT, cardToSalary = 5)
        return Result.success(Event(0, "test", user, 100))
    }
}