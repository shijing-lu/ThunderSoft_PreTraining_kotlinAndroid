package com.example.studywithfristlinecode

import android.app.AlertDialog
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.studywithfristlinecode.ui.theme.StudyWithFristLineCodeTheme

class DialogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AlertDialog.Builder(this).apply {
            setTitle("确认删除吗？")
            setMessage("一旦删除，数据无法恢复！")
            setPositiveButton("确定") { dialog, _ ->
                dialog.dismiss()
                finish()
            }
            setNegativeButton("取消") { dialog, _ ->
                dialog.dismiss()
                finish()
            }
            setOnCancelListener { finish() }
            create().show()
        }
    }
}

