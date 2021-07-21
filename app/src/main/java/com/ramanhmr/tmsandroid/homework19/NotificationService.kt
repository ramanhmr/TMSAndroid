package com.ramanhmr.tmsandroid.homework19

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.ramanhmr.tmsandroid.R

class NotificationService : Service() {
    override fun onBind(intent: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (intent?.getBooleanExtra(AlarmReceiver.ALARM_SOUND_KEY, false) == true) {
            MediaPlayer.create(applicationContext, R.raw.notification).start()
        }

        val notificationBuilder =
            NotificationCompat.Builder(this, NotificationService.CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_baseline_access_alarm_24)
                .setContentTitle(getString(R.string.alarm))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentText(getString(R.string.alarm))

        val notificationIntent = Intent(this, AlarmActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(
            this,
            0,
            notificationIntent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )
        notificationBuilder.setContentIntent(pendingIntent)

        val notificationManager: NotificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val descriptionText = getString(R.string.alarm)
            val channel = NotificationChannel(
                CHANNEL_ID,
                NOTIFICATION_CHANNEL,
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                description = descriptionText
            }
            notificationManager.createNotificationChannel(channel)
        }

        notificationManager.notify(0, notificationBuilder.build())

        return START_NOT_STICKY
    }

    companion object {
        const val CHANNEL_ID = "CHANNEL_ID"
        const val NOTIFICATION_CHANNEL = "NOTIFICATION_CHANNEL"
    }
}