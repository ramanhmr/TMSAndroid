package com.ramanhmr.tmsandroid.homework19

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build

class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val serviceIntent = Intent(context, NotificationService::class.java)
            .putExtra(ALARM_SOUND_KEY, intent?.getBooleanExtra(ALARM_SOUND_KEY, false))

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            context?.startForegroundService(serviceIntent)
        } else {
            context?.startService(serviceIntent)
        }
    }

    companion object {
        const val ACTION = "ALARM_ACTION"
        const val ALARM_SOUND_KEY = "ALARM_SOUND_KEY"
    }
}