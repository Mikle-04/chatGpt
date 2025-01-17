package com.example.chatgpt.domain.usecase

import com.example.chatgpt.domain.models.LoginResult
import com.example.chatgpt.domain.repository.AuthRepository

class LoginUseCase(private val repository: AuthRepository) {
    suspend operator fun invoke(email: String, password: String): LoginResult {
        if (email.isBlank() || password.isBlank()) {
            return LoginResult.Error("Email и пароль не могут быть пустыми")
        }
        return repository.login(email, password)
    }
}