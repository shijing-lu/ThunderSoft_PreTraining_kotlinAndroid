package com.example.studywithfristlinecode

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.TextView
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

class SecondActivity : ComponentActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.secondlayout)
        val extraData=intent.getStringExtra("extra_data")
        Log.d("Second Activity","extraData is $extraData")
        val textView :TextView=findViewById<TextView>(R.id.sceond_button)
    }
}

