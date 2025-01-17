package com.example.chatgpt.data.auth.dto

data class LoginResponse(
    val success: Boolean,
    val token: String? = null,
    val message: String? = null
)