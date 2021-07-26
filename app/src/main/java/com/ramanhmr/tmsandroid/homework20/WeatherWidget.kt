package com.ramanhmr.tmsandroid.homework20

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import android.widget.RemoteViews
import com.ramanhmr.tmsandroid.R
import com.ramanhmr.tmsandroid.homework20.restApi.entities.Weather

class WeatherWidget : AppWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager?,
        appWidgetIds: IntArray?
    ) {
        super.onUpdate(context, appWidgetManager, appWidgetIds)
        val remoteViews = RemoteViews(context.packageName, R.layout.widget_weather)
        remoteViews.setOnClickPendingIntent(R.id.iv_refresh, getRefreshRequestIntent(context))

        appWidgetManager?.updateAppWidget(appWidgetIds, remoteViews)

        refresh(context)
    }

    override fun onReceive(context: Context, intent: Intent?) {
        super.onReceive(context, intent)

        Log.i("KEK", "In onReceive() with ${intent?.action}")

        val remoteViews = RemoteViews(context.packageName, R.layout.widget_weather)

        when (intent?.action) {
            REFRESH -> refresh(context)
            UPDATE -> setNewWeather(remoteViews, intent)
        }

        remoteViews.setOnClickPendingIntent(R.id.iv_refresh, getRefreshRequestIntent(context))

        val appWidgetManager = AppWidgetManager.getInstance(context)
        val componentWidget = ComponentName(context, javaClass)
        val ids = appWidgetManager.getAppWidgetIds(componentWidget)
        appWidgetManager.updateAppWidget(ids, remoteViews)
    }

    private fun refresh(context: Context) {
        val serviceIntent = Intent(context, UpdateWeatherWidgetService::class.java)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            Log.i("KEK", "Trying to start ForegroundService")

            context.startForegroundService(serviceIntent)
        } else {
            context.startService(serviceIntent)
        }
    }

    private fun setNewWeather(remoteViews: RemoteViews, intent: Intent?) {
        val weather = intent?.getParcelableExtra<Weather>(WEATHER_EXTRA_KEY)
        with(remoteViews) {
            setTextViewText(R.id.tv_temperature, weather?.temperature)
            setTextViewText(R.id.tv_city, weather?.cityName)
            setTextViewText(R.id.tv_weather, weather?.description)
            setTextViewText(R.id.tv_wind_speed, weather?.windSpeed)
            setTextViewText(R.id.tv_wind_direction, weather?.windDirection)
        }
    }

    private fun getRefreshRequestIntent(context: Context?): PendingIntent? {
        val intent = Intent(context, javaClass)
        intent.action = REFRESH
        return PendingIntent.getBroadcast(context, 0, intent, 0)
    }

    companion object {
        const val REFRESH = "REFRESH"
        const val UPDATE = "UPDATE"

        const val WEATHER_EXTRA_KEY = "WEATHER_EXTRA_KEY"
    }
}