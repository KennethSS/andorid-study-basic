package com.solar.studybasic.thread

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import androidx.appcompat.app.AppCompatActivity
import com.solar.studybasic.R
import kotlinx.android.synthetic.main.activity_thread.*

class ThreadActivity : AppCompatActivity() {

    //private val handler: TextHandler by lazy { TextHandler(mainLooper, timer) }

    private val handler = Handler(Looper.getMainLooper()) {
        timer.text = it.arg1.toString()
        true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread)



        val threadRunnable = Runnable {
            Looper.prepare()
            for (i in 0..10) {
                Thread.sleep(1000)

                handler.sendMessage(Message().apply {
                    arg1 = i
                })

                //handler.post(mainRunnable)
            }
            Looper.loop()
        }

        Thread(threadRunnable).start()
    }
}