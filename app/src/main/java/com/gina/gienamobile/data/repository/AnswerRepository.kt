package com.gina.gienamobile.data.repository

import com.gina.gienamobile.data.model.Answer

interface AnswerRepository {
    suspend fun getAnswerById(id: String): Result<Answer>
}