package com.example.studywithfristlinecode

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
class MyService : Service() {
    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }
    override fun onCreate() {
        super.onCreate()
        Log.d("MyService", "onCreate executed")
    }
    //在Service启动时调用
    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        Log.d("MyService", "onStartCommand executed")
        return super.onStartCommand(intent, flags, startId)
    }
    //在Service被销毁时调用，主要用于回收资源
    override fun onDestroy() {
        super.onDestroy()
        Log.d("MyService", "onDestroy executed")
    }
}