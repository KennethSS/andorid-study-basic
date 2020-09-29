package com.solar.studybasic

import android.app.Fragment
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.solar.studybasic.service.ServiceActivity
import com.solar.studybasic.thread.ThreadActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        thread_activity.setOnClickListener {
            startActivity(Intent(it.context, ThreadActivity::class.java))
        }

        service_activity.setOnClickListener {
            startActivity(Intent(it.context, ServiceActivity::class.java))
        }
    }
}