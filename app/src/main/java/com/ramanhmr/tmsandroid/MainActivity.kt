package com.ramanhmr.tmsandroid

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ramanhmr.tmsandroid.databinding.ActivityMainBinding
import com.ramanhmr.tmsandroid.homework6.Homework6Activity
import com.ramanhmr.tmsandroid.homework7.CountdownActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnHomework6.setOnClickListener {
            startActivity(Intent(this, Homework6Activity::class.java))
        }
        binding.btnHomework7.setOnClickListener {
            startActivity(Intent(this, CountdownActivity::class.java))
        }
    }
}