package com.ramanhmr.tmsandroid

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.ramanhmr.tmsandroid.databinding.ActivityMainBinding
import com.ramanhmr.tmsandroid.homework10.CandiesActivity
import com.ramanhmr.tmsandroid.homework12.FragmentsActivity
import com.ramanhmr.tmsandroid.homework13.CandyFragmentActivity
import com.ramanhmr.tmsandroid.homework16.MessagesActivity
import com.ramanhmr.tmsandroid.homework17.CurrencyActivity
import com.ramanhmr.tmsandroid.homework19.AlarmActivity
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
        binding.btnFragments.setOnClickListener(this)
        binding.btnCandyFragments.setOnClickListener(this)
        binding.btnMessages.setOnClickListener(this)
        binding.btnCurrencies.setOnClickListener(this)
        binding.btnAlarmClock.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btn_candies -> startActivity(Intent(view.context, CandiesActivity::class.java))
            R.id.btn_countdown -> startActivity(Intent(view.context, CountdownActivity::class.java))
            R.id.btn_flags -> startActivity(Intent(view.context, FlagsActivity::class.java))
            R.id.btn_fragments -> startActivity(Intent(view.context, FragmentsActivity::class.java))
            R.id.btn_candy_fragments -> startActivity(
                Intent(
                    view.context,
                    CandyFragmentActivity::class.java
                )
            )
            R.id.btn_messages -> startActivity(Intent(view.context, MessagesActivity::class.java))
            R.id.btn_currencies -> startActivity(Intent(view.context, CurrencyActivity::class.java))
            R.id.btn_alarm_clock -> startActivity(Intent(view.context, AlarmActivity::class.java))
        }
    }
}