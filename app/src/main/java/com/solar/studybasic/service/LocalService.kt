package com.solar.studybasic.service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import java.util.*

class LocalService : Service() {

    private val binder = LocalBinder()

    private val generator = Random()

    val randomNumber: Int
        get() = generator.nextInt(100)

    override fun onBind(p0: Intent?): IBinder? = binder

    inner class LocalBinder : Binder() {
        fun getService(): LocalService = this@LocalService
    }
}