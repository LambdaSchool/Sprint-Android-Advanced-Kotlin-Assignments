package com.example.week11module3assignment.util.extensions

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import androidx.core.app.NotificationCompat

fun Context.showAlert(title: String = "", message: String = "") {

    AlertDialog.Builder(this)
        .setTitle(title)
        .setMessage(message)
        .create().show()
}