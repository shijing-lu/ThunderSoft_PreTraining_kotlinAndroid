package com.example.studywithfristlinecode

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge


class AsynMessageHandleActivity : ComponentActivity() {
    private val mainHandler = object :Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            when (msg.what) {
                // 3. 在主线程处理消息（更新UI）
                MSG_UPDATE_TEXT -> {
                    findViewById<TextView>(R.id.textView).text = msg.obj as String
                }
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.asyncmessagehandle_layout)
        val btnStart: Button=findViewById(R.id.btnStart)
        btnStart.setOnClickListener {
            // 启动工作线程
            Thread(WorkTask()).start()
        }
    }
    private inner class WorkTask : Runnable {
        override fun run() {
            // 模拟耗时操作
            Thread.sleep(2000)
            // 创建消息对象
            val message = Message().apply {
                what = MSG_UPDATE_TEXT
                obj = "来自工作线程的消息 ${System.currentTimeMillis()}"
            }
            // 发送消息到主线程
            mainHandler.sendMessage(message)
        }
    }
    companion object {
        const val MSG_UPDATE_TEXT = 1
    }
}