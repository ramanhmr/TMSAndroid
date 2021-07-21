package com.ramanhmr.tmsandroid.homework19

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        context?.startService(
            Intent(context, NotificationService::class.java)
                .putExtra(ALARM_SOUND_KEY, intent?.getBooleanExtra(ALARM_SOUND_KEY, false))
        )
    }

    companion object {
        const val ACTION = "ALARM_ACTION"
        const val ALARM_SOUND_KEY = "ALARM_SOUND_KEY"
    }
}