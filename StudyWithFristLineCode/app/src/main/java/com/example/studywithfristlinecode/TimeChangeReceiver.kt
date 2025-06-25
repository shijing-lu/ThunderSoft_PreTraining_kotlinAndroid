package com.example.studywithfristlinecode

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class TimeChangeReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent?) {
        when (intent?.action) {
            Intent.ACTION_TIME_CHANGED -> {
                Log.d("TimeBroadcast", "广播收到处理")
            }
        }
    }
}
