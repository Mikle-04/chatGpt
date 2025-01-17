package com.example.chatgpt.domain.repository

import com.example.chatgpt.domain.models.LoginResult

interface AuthRepository {
    suspend fun login(email: String, password: String): LoginResult
}