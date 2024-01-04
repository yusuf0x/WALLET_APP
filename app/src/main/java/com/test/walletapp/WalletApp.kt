package com.test.walletapp

import android.app.Application
import android.content.Context

class WalletApp : Application() {
    companion object {
        lateinit var appContext: Context
            private set
    }
    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
    }

}