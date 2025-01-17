package com.example.chatgpt

import android.app.Application
import appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ChatGptApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ChatGptApp)
            modules(appModule)
        }
    }
}