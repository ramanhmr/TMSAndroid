package com.ramanhmr.tmsandroid.homework7

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.ramanhmr.tmsandroid.R
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
        Glide
            .with(this)
            .load(IMAGE_ADDRESS)
            .placeholder(R.drawable.ic_baseline_account_circle_24)
            .into(binding.ivProfilePicture)
    }

    companion object {
        private const val IMAGE_ADDRESS = "https://thispersondoesnotexist.com/image"
    }
}