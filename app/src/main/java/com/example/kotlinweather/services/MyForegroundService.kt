package com.example.kotlinweather.services

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.app.TaskStackBuilder
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.example.kotlinweather.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MyForegroundService : Service(), CoroutineScope by MainScope() {
    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()

        val launchIntent = packageManager.getLaunchIntentForPackage(packageName)
        val stackBuilder: TaskStackBuilder = TaskStackBuilder.create(this)
        stackBuilder.addNextIntentWithParentStack(launchIntent)
        val pendingIntent = stackBuilder.getPendingIntent(
            0,
            PendingIntent.FLAG_UPDATE_CURRENT
        )

        val notification = NotificationCompat.Builder(this, "some_channel")
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentIntent(pendingIntent)
            .setOngoing(true)
            .setStyle(NotificationCompat.DecoratedCustomViewStyle())
            .setSound(null)
            .build()

        startForeground(12345, notification)

        launch {
            delay(300)
            sendMyBroadcast()
        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        //...ваш код
        //...
        //возникла нужда отправить сообщение

        return START_NOT_STICKY
    }

    private fun sendMyBroadcast() {
        val broadcastIntent = Intent()
        broadcastIntent.putExtra(INTENT_SERVICE_DATA, true)
        broadcastIntent.action = INTENT_ACTION_KEY
        sendBroadcast(broadcastIntent)
    }

    override fun onBind(intent: Intent?): IBinder? = null

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel =
                NotificationChannel("some_channel", "Progress", NotificationManager.IMPORTANCE_DEFAULT)
            val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(notificationChannel)
        }
    }

    companion object {
        const val INTENT_ACTION_KEY = "com.example.a2kotlinwithmvvm.SERVICE_FINISHED_EVENT"
        const val INTENT_SERVICE_DATA = "INTENT_SERVICE_DATA"

        fun start(context: Context) {
            val usualServiceIntent = Intent(context, MyForegroundService::class.java)
            context.startService(usualServiceIntent)
        }

        fun stop(context: Context) {
            val usualServiceIntent = Intent(context, MyForegroundService::class.java)
            context.stopService(usualServiceIntent)
        }
    }
}