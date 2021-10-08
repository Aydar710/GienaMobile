package com.gina.gienamobile.data.repository

import com.gina.gienamobile.data.model.Question

interface QuestionRepository {
    suspend fun getQuestion(): Result<List<Question>>
    suspend fun getQuestionById(id: String): Result<Question>
}