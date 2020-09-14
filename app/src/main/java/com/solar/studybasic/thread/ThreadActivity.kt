package com.solar.studybasic.thread

import android.os.Bundle
import android.os.Handler
import android.os.Message
import androidx.appcompat.app.AppCompatActivity
import com.solar.studybasic.R
import kotlinx.android.synthetic.main.activity_thread.*

class ThreadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread)

        val handler = object: Handler(mainLooper) {

            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                timer.text = msg.arg1.toString()
            }
        }

        val mainRunnable = object: Runnable {
            var t = 0
            override fun run() {
                timer.text = t.toString()
                t++
            }
        }

        val threadRunnable = Runnable {
            for (i in 0..10) {
                Thread.sleep(1000)
                handler.post(mainRunnable)
            }
        }

        val runnable = Runnable {
            for (i in 0..10) {
                Thread.sleep(1000)

                handler.post(threadRunnable)

                /*handler.sendMessage(Message().also {
                    it.arg1 = i
                    //it.arg1
                    //it.arg2
                })*/

            }
        }
        Thread(threadRunnable).start()
    }
}