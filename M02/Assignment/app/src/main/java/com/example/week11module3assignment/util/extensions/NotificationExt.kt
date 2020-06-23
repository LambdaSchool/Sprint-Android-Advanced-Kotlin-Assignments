package com.example.week11module3assignment.util.extensions

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Build.*
import android.os.Build.VERSION.*
import android.provider.Settings.Global.getString
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat.getSystemService
import com.example.week11module3assignment.R
import com.example.week11module3assignment.util.extensions.NotificationStuff.CHANNEL_ID
import com.example.week11module3assignment.util.extensions.NotificationStuff.NOTIFICATION_ID

object NotificationStuff {
    const val CHANNEL_ID = "CHANNEL_ID"
    const val NOTIFICATION_ID = 0
}
fun Context.createNotification(channelId: String, icon: Int, title: String = "", description: String) {
    NotificationCompat.Builder(this,channelId)
        .setSmallIcon(icon)
        .setContentTitle(title)
        .setContentText(description)
        .priority = NotificationCompat.PRIORITY_DEFAULT
}
fun Context.createNofificationChannel(descriptionText: String) {
    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val name = NotificationStuff.CHANNEL_ID
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channel = NotificationChannel(CHANNEL_ID,name,importance). apply {
            description = descriptionText
        }
        val notificationManager: NotificationManager =
            this.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }
}
fun Context.showNotification() {
    with(NotificationManagerCompat.from(this)) {
        notify(NOTIFICATION_ID, builder.Build())
    }
}