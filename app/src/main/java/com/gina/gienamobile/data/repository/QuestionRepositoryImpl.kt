package com.gina.gienamobile.data.repository

import com.gina.gienamobile.data.model.Answer
import com.gina.gienamobile.data.model.Question

class QuestionRepositoryImpl() : QuestionRepository {
    override suspend fun getQuestions(): Result<List<Question>> {
        return Result.success(listOf())
    }

    override suspend fun getQuestionById(id: String): Result<Question> {
        val negativeDecisionAnswer = Answer(0, "test", 100, "ответ")
        val positiveDecisionAnswer = Answer(1, "test", 100, "ответ")
        return Result.success(Question(0, "test", negativeDecisionAnswer, positiveDecisionAnswer))
    }
}