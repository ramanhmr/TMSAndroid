package com.ramanhmr.tmsandroid.homework7

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.ramanhmr.tmsandroid.R

class UserInfoActivity : AppCompatActivity() {
    private lateinit var loginInfoTV: TextView
    private lateinit var passwordInfoTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hw7_user_info)

        loginInfoTV = findViewById(R.id.tv_login)
        loginInfoTV.text = intent.getStringExtra(CountdownActivity.LOGIN)

        passwordInfoTV = findViewById(R.id.tv_password)
        passwordInfoTV.text = intent.getStringExtra(CountdownActivity.PASSWORD)
    }
}