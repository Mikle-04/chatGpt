package com.example.chatgpt.data.auth.api

import com.example.chatgpt.data.auth.dto.LoginRequest
import com.example.chatgpt.data.auth.dto.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST("auth/login")
    suspend fun login(@Body request: LoginRequest): LoginResponse
}