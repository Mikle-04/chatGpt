package com.example.chatgpt.data.auth.repositoryImpl

import com.example.chatgpt.data.auth.api.AuthApi
import com.example.chatgpt.data.auth.dto.LoginRequest
import com.example.chatgpt.domain.models.LoginResult
import com.example.chatgpt.domain.repository.AuthRepository

class AuthRepositoryImpl(private val api: AuthApi) : AuthRepository {
    override suspend fun login(email: String, password: String): LoginResult {
        return try {
            val response = api.login(LoginRequest(email, password))
            if (response.success) {
                LoginResult.Success(response.token ?: "")
            } else {
                LoginResult.Error(response.message ?: "Ошибка авторизации")
            }
        } catch (e: Exception) {
            LoginResult.Error("Ошибка подключения: ${e.message}")
        }
    }
}