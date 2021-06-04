package com.ramanhmr.tmsandroid.homework7

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.ramanhmr.tmsandroid.R

class CountdownActivity : AppCompatActivity() {
    private var counter: Int = 10
    private lateinit var tappingBtn: Button
    private lateinit var countTV: TextView
    private lateinit var loginET: EditText
    private lateinit var passwordET: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hw7_countdown)

        countTV = findViewById(R.id.tv_count)
        countTV.text = counter.toString()

        loginET = findViewById(R.id.et_login)
        passwordET = findViewById(R.id.et_password)

        tappingBtn = findViewById(R.id.btn_tapMe)
        tappingBtn.setOnClickListener {
            counter--
            if (counter > 0) {
                countTV.text = counter.toString()
            } else {
                tappingBtn.text = getString(R.string.hw7_enter)
                countTV.visibility = View.GONE
                loginET.visibility = View.VISIBLE
                passwordET.visibility = View.VISIBLE
                tappingBtn.setOnClickListener {
                    Log.i("KEK", passwordET.text.toString())
                    startActivity(
                        Intent(this, UserInfoActivity::class.java)
                            .putExtra("login", loginET.text.toString())
                            .putExtra("password", passwordET.text.toString()))
                }
            }
        }
    }
}