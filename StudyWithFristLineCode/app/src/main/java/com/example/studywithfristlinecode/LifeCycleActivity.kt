package com.example.studywithfristlinecode

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.studywithfristlinecode.ui.theme.StudyWithFristLineCodeTheme
class LifeCycleActivity : ComponentActivity() {
    private lateinit var overlayView: View
    private lateinit var lifecycleStatus: TextView
    private lateinit var overlayHint: TextView
    // 统一的日志标签
    private val TAG = "LifeCycleActivitydemo"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()  // 启用边缘到边缘显示
        setContentView(R.layout.lifecycle_layout)
        lifecycleStatus = findViewById(R.id.lifecycleStatus)
        // 设置删除点击事件
        findViewById<Button>(R.id.AlertDialog).setOnClickListener {
            startActivity(Intent(this, DialogActivity::class.java))
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: Activity可见但不在前台")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: Activity进入前台，可与用户交互")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: Activity部分可见，准备进入后台")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: Activity完全不可见")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart: Activity从停止状态重新启动")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: Activity即将被销毁")
    }
}
