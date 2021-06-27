package com.ramanhmr.tmsandroid.homework7

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.ramanhmr.tmsandroid.R
import com.ramanhmr.tmsandroid.databinding.ActivityUserInfoBinding

class UserInfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            tvLogin.text = intent.getStringExtra(CountdownActivity.LOGIN_KEY)
            tvPassword.text = intent.getStringExtra(CountdownActivity.PASSWORD_KEY)
            btnClose.setOnClickListener { finish() }
        }

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