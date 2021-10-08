package com.gina.gienamobile.data.repository

import com.gina.gienamobile.data.model.Answer
import com.gina.gienamobile.data.model.Question

class QuestionRepositoryImpl() : QuestionRepository {
    override suspend fun getQuestion(): Result<List<Question>> {
        return Result.success(listOf())
    }

    override suspend fun getQuestionById(id: String): Result<Question> {
        val negativeDecisionAnswer = Answer("id", "test", 100)
        val positiveDecisionAnswer = Answer("id", "test", 100)
        return Result.success(Question("1", "test", negativeDecisionAnswer, positiveDecisionAnswer))
    }
}