package com.gina.gienamobile.data.repository

import com.gina.gienamobile.data.enums.Roles.STUDENT
import com.gina.gienamobile.data.model.Answer
import com.gina.gienamobile.data.model.Question
import com.gina.gienamobile.data.model.User

class QuestionRepositoryImpl() : QuestionRepository {

    override suspend fun getQuestions(): Result<List<Question>> {
        return Result.success(listOf())
    }

    override suspend fun getQuestionById(id: String): Result<Question> {
        val negativeDecisionAnswer = Answer(0, "test", 100, "ответ")
        val positiveDecisionAnswer = Answer(1, "test", 100, "ответ")
        val user =  User(id = 1, username = "Vatabe", 123, STUDENT, cardToSalary = 5)
        return Result.success(Question(0, "test", user, negativeDecisionAnswer, positiveDecisionAnswer))
    }
}