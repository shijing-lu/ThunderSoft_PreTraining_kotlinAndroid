package com.example.studywithfristlinecode

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class SecondBroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
//        TODO("SecondBroadcastReceiver.onReceive() is not implemented")
        Toast.makeText(context,"this is SecondBroadcast!", Toast.LENGTH_SHORT).show()
    }
}