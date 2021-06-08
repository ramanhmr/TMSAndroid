package com.ramanhmr.tmsandroid.homework7

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.ramanhmr.tmsandroid.R
import com.ramanhmr.tmsandroid.databinding.ActivityHw7CountdownBinding

class CountdownActivity : AppCompatActivity() {
    private var counter: Int = 10
    private var btnOnClick: (View) -> Unit = {
        counter--
        if (counter > 0) {
            binding.tvCount.text = counter.toString()
        } else {
            showEditText()
        }
    }
    private lateinit var binding: ActivityHw7CountdownBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHw7CountdownBinding.inflate(layoutInflater)
        setContentView(binding.root)
        savedInstanceState?.let {
            counter = it.getInt(COUNTER_KEY)
            if (it.getBoolean(COUNTED_KEY)) showEditText()
        }
        binding.tvCount.text = counter.toString()
        binding.btnTapMe.setOnClickListener(btnOnClick)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(COUNTER_KEY, counter)
        outState.putBoolean(COUNTED_KEY, binding.tvCount.visibility == View.GONE)
        super.onSaveInstanceState(outState)
    }

    private fun showEditText() {
        binding.btnTapMe.text = getString(R.string.hw7_enter)
        binding.tvCount.visibility = View.GONE
        binding.vgLoginPassword.visibility = View.VISIBLE
        changeBtnOnClick()
        binding.btnTapMe.setOnClickListener(btnOnClick)
    }

    private fun changeBtnOnClick() {
        btnOnClick = {
            startActivity(
                Intent(this, UserInfoActivity::class.java)
                    .putExtra(LOGIN_KEY, binding.etLogin.text.toString())
                    .putExtra(PASSWORD_KEY, binding.etPassword.text.toString()))
        }
    }

    companion object {
        const val LOGIN_KEY = "LOGIN_KEY"
        const val PASSWORD_KEY = "PASSWORD_KEY"
        private const val COUNTER_KEY = "COUNTER_KEY"
        private const val COUNTED_KEY = "COUNTED_KEY"
    }
}