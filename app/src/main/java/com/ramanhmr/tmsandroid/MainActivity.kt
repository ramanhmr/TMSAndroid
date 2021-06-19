package com.ramanhmr.tmsandroid

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ramanhmr.tmsandroid.databinding.ActivityMainBinding
import com.ramanhmr.tmsandroid.homework10.CandiesActivity
import com.ramanhmr.tmsandroid.homework6.FlagsActivity
import com.ramanhmr.tmsandroid.homework7.CountdownActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnFlags.setOnClickListener {
            startActivity(Intent(this, FlagsActivity::class.java))
        }
        binding.btnCountdown.setOnClickListener {
            startActivity(Intent(this, CountdownActivity::class.java))
        }

        binding.btnCandies.setOnClickListener {
            startActivity(Intent(this, CandiesActivity::class.java))
        }
    }
}