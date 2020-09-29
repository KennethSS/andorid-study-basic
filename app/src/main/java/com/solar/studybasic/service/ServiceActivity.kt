package com.solar.studybasic.service

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.solar.studybasic.R
import kotlinx.android.synthetic.main.activity_service.*

class ServiceActivity : AppCompatActivity() {
    private lateinit var service: LocalService
    private var bound = false

    private val connection= object : ServiceConnection {
        override fun onServiceDisconnected(p0: ComponentName?) {
            val binder = service as LocalService.LocalBinder
            service = binder.getService()
            bound = true
        }

        override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
            bound = false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)
        text.setOnClickListener {  onButtonClick() }
    }

    override fun onStart() {
        super.onStart()
        // Bind to LocalService
        Intent(this, LocalService::class.java).also { intent ->
            bindService(intent, connection, Context.BIND_AUTO_CREATE)
        }
    }

    override fun onStop() {
        super.onStop()
        unbindService(connection)
        bound = false
        stopService(Intent(this, LocalService::class.java))
    }

    fun onButtonClick() {
        Log.d("ServiceActivity", bound.toString())
        startService(Intent(this, LocalService::class.java))
        if (bound) {
            val num = service.randomNumber
            Toast.makeText(this, "number: $num", Toast.LENGTH_SHORT).show()
        }
    }
}