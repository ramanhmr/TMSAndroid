package com.ramanhmr.tmsandroid.homework7

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ramanhmr.tmsandroid.databinding.ActivityHw7UserInfoBinding

class UserInfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHw7UserInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHw7UserInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvLogin.text = intent.getStringExtra(CountdownActivity.LOGIN_KEY)
        binding.tvPassword.text = intent.getStringExtra(CountdownActivity.PASSWORD_KEY)
        binding.btnClose.setOnClickListener { this.finish() }
    }
}