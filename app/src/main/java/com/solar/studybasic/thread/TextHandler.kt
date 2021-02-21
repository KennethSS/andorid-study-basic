package com.solar.studybasic.thread

import android.os.Handler
import android.os.Looper
import android.os.Message
import android.widget.TextView

class TextHandler(looper: Looper, private val tv: TextView) : Handler(looper) {
    override fun handleMessage(msg: Message) {
        super.handleMessage(msg)
        tv.text = msg.arg1.toString()
    }

    override fun sendMessageAtTime(msg: Message, uptimeMillis: Long): Boolean {
        return super.sendMessageAtTime(msg, uptimeMillis)

    }
}