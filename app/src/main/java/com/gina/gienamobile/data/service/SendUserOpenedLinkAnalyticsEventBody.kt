package com.gina.gienamobile.data.service

data class SendUserOpenedLinkAnalyticsEventBody(
    val user_id: Int,
    val link: String
)