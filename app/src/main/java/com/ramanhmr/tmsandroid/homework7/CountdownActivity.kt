package com.ramanhmr.tmsandroid.homework7

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
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
    private lateinit var loginPassVG: ViewGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hw7_countdown)

        countTV = findViewById(R.id.tv_count)
        countTV.text = counter.toString()
        loginET = findViewById(R.id.et_login)
        passwordET = findViewById(R.id.et_password)
        tappingBtn = findViewById(R.id.btn_tapMe)
        loginPassVG = findViewById(R.id.vg_login_password)
        tappingBtn.setOnClickListener {
            counter--
            if (counter > 0) {
                countTV.text = counter.toString()
            } else {
                tappingBtn.text = getString(R.string.hw7_enter)
                countTV.visibility = View.GONE
                loginPassVG.visibility = View.VISIBLE
                tappingBtn.setOnClickListener {
                    Log.i("KEK", passwordET.text.toString())
                    startActivity(
                        Intent(this, UserInfoActivity::class.java)
                            .putExtra(LOGIN, loginET.text.toString())
                            .putExtra(PASSWORD, passwordET.text.toString()))
                }
            }
        }
    }

    companion object {
        const val LOGIN = "login"
        const val PASSWORD = "password"
    }
}