package com.example.studywithfristlinecode

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.studywithfristlinecode.ui.theme.StudyWithFristLineCodeTheme

class ThirdActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.third_layout)
        val button:Button=findViewById(R.id.third_button4)
        //点击返回时自动触发
        val intent = Intent()
        intent.putExtra("return_data","hello,this is ThirdActivity message!")
        setResult(Activity.RESULT_OK, intent)
//        点击事件销毁，触发数据返回
        button.setOnClickListener {
            val intent = Intent()
            intent.putExtra("return_data","hello,this is ThirdActivity message!")
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

    }
}

