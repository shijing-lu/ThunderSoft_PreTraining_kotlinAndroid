package com.example.studywithfristlinecode

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
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

class ControlsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.controls_layout)
        val show_progressBar:Button=findViewById(R.id.showProgressBar)
        val progressBar: ProgressBar=findViewById(R.id.progressBar)
        val add_progressBar:Button=findViewById(R.id.add_progressBar)
        add_progressBar.setOnClickListener {
            progressBar.progress+=10
        }
        show_progressBar.setOnClickListener {
            when(progressBar.visibility){
                View.VISIBLE->progressBar.visibility=View.GONE
                View.GONE->progressBar.visibility=View.VISIBLE
            }
        }

    }
}
