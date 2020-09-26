package com.powder.powdertest

import android.app.Application

class App : Application() {
    override fun onCreate() {
        FakeDependencyInjection.init(this)
        super.onCreate()
    }
}