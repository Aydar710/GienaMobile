package com.gina.gienamobile.data.repository

interface AnalyticsRepository {

    suspend fun sendUserOpenedLink(userId: Int, link: String): Result<Unit>
}