package com.gina.gienamobile.data.repository

import com.gina.gienamobile.data.model.Event

interface EventRepository {
    suspend fun getEvents(): Result<List<Event>>
    suspend fun getEventById(id: String): Result<Event>
}