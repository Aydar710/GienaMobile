package com.gina.gienamobile.data.repository

import com.gina.gienamobile.data.model.Answer
import java.util.*

class AnswerRepositoryImpl() : AnswerRepository {
    override suspend fun getAnswers(): Result<List<Answer>> {
        return Result.success(listOf());
    }

    override suspend fun getAnswerById(id: String): Result<Answer> {
        return Result.success(Answer("id", "test", "test"));
    }
}