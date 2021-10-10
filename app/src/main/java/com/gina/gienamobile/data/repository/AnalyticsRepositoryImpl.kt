package com.gina.gienamobile.data.repository

import com.gina.gienamobile.data.makeApiCall
import com.gina.gienamobile.data.service.GienaService
import com.gina.gienamobile.data.service.SendUserOpenedLinkAnalyticsEventBody

class AnalyticsRepositoryImpl(private val service: GienaService) : AnalyticsRepository {

    override suspend fun sendUserOpenedLink(userId: Int, link: String): Result<Unit> {
        val body = SendUserOpenedLinkAnalyticsEventBody(userId, link)
        return makeApiCall { service.sendUserOpenedLinkAnalyticsEvent(body) }
    }
}
