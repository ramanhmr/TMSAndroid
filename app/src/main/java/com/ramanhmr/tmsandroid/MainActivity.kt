package com.ramanhmr.tmsandroid

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.ramanhmr.tmsandroid.homework6.Homework6Activity

class MainActivity : AppCompatActivity() {
    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.tv)
        textView.setOnClickListener {
            startActivity(Intent(this, Homework6Activity::class.java))
        }
    }
}