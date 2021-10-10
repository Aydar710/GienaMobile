package com.gina.gienamobile.data.service

import com.gina.gienamobile.data.model.CardResponseWrapper
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GienaService {

    @GET("get-card")
    suspend fun getCard(
        @Query("user_id") userId: Int
    ): Response<CardResponseWrapper>
}