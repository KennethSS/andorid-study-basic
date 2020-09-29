package com.solar.studybasic.kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import com.solar.studybasic.R

class SampleActivity : AppCompatActivity() {

    private val textView: AppCompatTextView by lazy { findViewById<AppCompatTextView>(R.id.tv_title) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample)
        textView.text = "Sample"
    }
}