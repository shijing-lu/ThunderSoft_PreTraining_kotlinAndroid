package com.example.studywithfristlinecode

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class CustomizeBroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        Toast.makeText(
            context, "this is CustomizeBroadcastReceiver！ ",
            Toast.LENGTH_SHORT
        ).show()
        abortBroadcast()
    }
}

