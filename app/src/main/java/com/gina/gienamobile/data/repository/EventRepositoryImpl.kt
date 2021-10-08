package com.gina.gienamobile.data.repository

import com.gina.gienamobile.data.model.Answer
import com.gina.gienamobile.data.model.Event

class EventRepositoryImpl() : EventRepository {
    override suspend fun getEvents(): Result<List<Event>> {
        return Result.success(listOf());
    }

    override suspend fun getEventById(id: String): Result<Event> {
        return Result.success(Event("id", "test", "test"));
    }
}