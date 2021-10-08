package com.gina.gienamobile.data.repository

import com.gina.gienamobile.data.model.Answer
import java.util.*

class AnswerRepositoryImpl() : AnswerRepository {
    override suspend fun getAnswerById(id: String): Result<Answer> {
        return Result.success(Answer(0, "test", 100, "Ответ на вопрос"))
    }
}