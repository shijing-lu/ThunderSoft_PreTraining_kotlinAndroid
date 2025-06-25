package com.example.studywithfristlinecode

import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Button

import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


class FirstActivity :  AppCompatActivity() {
    private lateinit var screenStateReceiver: ScreenStateReceiver
//    声明ActivityResultLauncher
private lateinit var resultLauncher: ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_layout)
        val button3: Button = findViewById(R.id.button3)
        val button4: Button=findViewById(R.id.button4)
        val LifeCycle: Button=findViewById(R.id.LifeCycle)
        val button6: Button=findViewById(R.id.button6)
        val button7: Button=findViewById(R.id.AlertDialog)
        val button8: Button=findViewById(R.id.ListView)
        val AsynMessageHandleActivity: Button = findViewById(R.id.AsynMessageHandleActivity)
        val startService:Button=findViewById(R.id.startService)
        val sentBroadcast: Button=findViewById(R.id.SentBroadcast)


// 创建过滤器，监听屏幕开关
        val intentFilter = IntentFilter().apply {
            addAction(Intent.ACTION_SCREEN_ON)   // 屏幕亮起
            addAction(Intent.ACTION_SCREEN_OFF)  // 屏幕关闭
        }

        // 注册广播接收器
        screenStateReceiver = ScreenStateReceiver()
        registerReceiver(screenStateReceiver, intentFilter)


        button3.setOnClickListener {
            val data="Hello this is firstActivity"
            val intent= Intent(this, SecondActivity::class.java)
            intent.putExtra("extra_data",data)
            startActivity(intent)
        }
//        button4.setOnClickListener {
//            val intent=Intent("com.example.StudyWithFristLineCode.ACTION_START")
//            startActivity(intent)
//        }

        // 注册启动器
        resultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            // 结果回调处理
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                // 处理返回的数据
                val returnValue = data?.getStringExtra("return_data")
                Toast.makeText(this, "返回结果: $returnValue", Toast.LENGTH_SHORT).show()
            }
        }
//        跳转ThirdActivity,期待回复
        button4.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            resultLauncher.launch(intent)

        }
//        生命周期
        button4.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            resultLauncher.launch(intent)

        }
        LifeCycle.setOnClickListener {
            val intent= Intent(this, LifeCycleActivity::class.java)
            startActivity(intent)
        }
//        常用控件
        button6.setOnClickListener {
            val intent= Intent(this, ControlsActivity::class.java)
            startActivity(intent)
        }
        button7.setOnClickListener {
            AlertDialog.Builder(this).apply{
                setTitle("确认删除吗？")
                setMessage("一旦删除，数据无法恢复！")
                setPositiveButton("确定"){
                    dialog,which->
                }
                setNeutralButton ("取消"){
                        dialog,which->
                }
                show()
            }
        }
        findViewById<Button>(R.id.CustomizeListView).setOnClickListener {
            val intent= Intent(this, CustomizeListViewActivity::class.java)
            startActivity(intent)
        }
        button8.setOnClickListener {
            val intent= Intent(this, ListViewActivity::class.java)
            startActivity(intent)
        }
        AsynMessageHandleActivity.setOnClickListener {
            val intent= Intent(this, AsynMessageHandleActivity::class.java)
            startActivity(intent)
        }
        startService.setOnClickListener {
            val intent = Intent(this, MyService::class.java)
            startService(intent) // 启动Service
        }
        sentBroadcast.setOnClickListener {
            val intent= Intent("com.example.StudyWithFristLineCode.CUSTOMIZE_BROADCAST")
            intent.setPackage(packageName)
//            sendBroadcast(intent)
            sendOrderedBroadcast(intent,null)
        }
        findViewById<View>(R.id.makeCall).setOnClickListener {
            if (ContextCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                // 2. 未授权时请求权限
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(android.Manifest.permission.CALL_PHONE),
                    1  // 自定义请求码
                )
            } else {
                // 3. 已授权直接拨号
                callPhone()
            }
        }
//        更改时间广播
        findViewById<Button>(R.id.btnChangeTime).setOnClickListener {
            val currentTime = SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Date())
            Toast.makeText(this, "当前时间: $currentTime", Toast.LENGTH_SHORT).show()
            // 测试：模拟时间更改广播
            sendBroadcast(Intent(Intent.ACTION_TIME_CHANGED))
        }

//        跳转电话列表
        findViewById<View>(R.id.phoneList).setOnClickListener {
            val intent= Intent(this, PhoneListActivity::class.java)
            startActivity(intent)
        }

//        从DataCenter中获取数据并展示
        findViewById<View>(R.id.showDataCenter).setOnClickListener {
            val intent= Intent(this, DataCenterActivity::class.java)
            startActivity(intent)
        }
    }
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            1 -> {
                // 检查是否获得授权
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    callPhone()
                } else {
                    Toast.makeText(this, "You denied the permission", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    // 封装拨号逻辑
    private fun callPhone() {
        try {
            val intent = Intent(Intent.ACTION_CALL).apply {
                data = Uri.parse("tel:17786505040")
            }
            startActivity(intent)
        } catch (e: SecurityException) {
            e.printStackTrace()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main,menu)
        return true
    }
// 广播接收器内部类
inner class ScreenStateReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        when (intent.action) {
            Intent.ACTION_SCREEN_ON ->
                Toast.makeText(context, "屏幕已亮起", Toast.LENGTH_SHORT).show()
            Intent.ACTION_SCREEN_OFF ->
                Toast.makeText(context, "屏幕已关闭", Toast.LENGTH_SHORT).show()
        }
    }
}

    override fun onDestroy() {
        super.onDestroy()

    }
}
