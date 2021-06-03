package com.ramanhmr.tmsandroid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.ramanhmr.tmsandroid.homework6.Homework6Activity

class MainActivity : AppCompatActivity() {
    private lateinit var homework6Button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        homework6Button = findViewById(R.id.btn_homework6)
        homework6Button.setOnClickListener {
            startActivity(Intent(this, Homework6Activity::class.java))
        }
    }
}