package com.ramanhmr.tmsandroid

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.ramanhmr.tmsandroid.databinding.ActivityMainBinding
import com.ramanhmr.tmsandroid.homework10.CandiesActivity
import com.ramanhmr.tmsandroid.homework6.FlagsActivity
import com.ramanhmr.tmsandroid.homework7.CountdownActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnFlags.setOnClickListener(this)
        binding.btnCountdown.setOnClickListener(this)
        binding.btnCandies.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btn_candies -> startActivity(Intent(view.context, CandiesActivity::class.java))
            R.id.btn_countdown -> startActivity(Intent(view.context, CountdownActivity::class.java))
            R.id.btn_flags -> startActivity(Intent(view.context, FlagsActivity::class.java))
        }
    }
}