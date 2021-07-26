package com.ramanhmr.tmsandroid.homework19

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ramanhmr.tmsandroid.R
import com.ramanhmr.tmsandroid.databinding.ActivityAlarmBinding
import org.koin.android.ext.android.inject
import java.util.*

class AlarmActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAlarmBinding
    private var alarmDate: Calendar = Calendar.getInstance().apply { time = Date() }
    private val alarmManager: AlarmManager by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlarmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.timePicker.setIs24HourView(true)
        binding.timePicker.setOnTimeChangedListener { view, hourOfDay, minute ->
            alarmDate.set(Calendar.HOUR_OF_DAY, hourOfDay)
            alarmDate.set(Calendar.MINUTE, minute)
        }

        binding.btnSaveAlarm.setOnClickListener {
            with(binding.datePicker) {
                alarmDate.set(Calendar.YEAR, year)
                alarmDate.set(Calendar.MONTH, month)
                alarmDate.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            }

            alarmManager.setExact(
                AlarmManager.RTC_WAKEUP,
                alarmDate.timeInMillis,
                PendingIntent.getBroadcast(
                    this,
                    0,
                    Intent(applicationContext, AlarmReceiver::class.java).apply {
                        action = AlarmReceiver.ACTION
                        putExtra(AlarmReceiver.ALARM_SOUND_KEY, binding.switchSound.isChecked)
                    },
                    PendingIntent.FLAG_UPDATE_CURRENT
                )
            )
            Toast.makeText(this, R.string.alarm_created, Toast.LENGTH_SHORT).show()
        }
    }
}