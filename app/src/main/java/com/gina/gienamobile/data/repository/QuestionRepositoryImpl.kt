package com.gina.gienamobile.data.repository

import com.gina.gienamobile.data.model.Question

class QuestionRepositoryImpl() : QuestionRepository {
    override suspend fun getQuestion(): Result<List<Question>> {
        return Result.success(listOf());
    }

    override suspend fun getQuestionById(id: String): Result<Question> {
        return Result.success(Question("1", "test", "test"))
    }
}