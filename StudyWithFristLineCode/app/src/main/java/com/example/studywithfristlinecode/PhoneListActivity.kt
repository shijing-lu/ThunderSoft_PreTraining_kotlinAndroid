package com.example.studywithfristlinecode

import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.ContactsContract
import android.provider.ContactsContract.CommonDataKinds.Phone
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
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
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.studywithfristlinecode.ui.theme.StudyWithFristLineCodeTheme

class PhoneListActivity : ComponentActivity() {
    private val contactsList = ArrayList<String>()
    private lateinit var adapter: ArrayAdapter<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.phonelist_layout)
        // 初始化ListView适配器
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, contactsList)
        findViewById<ListView>(R.id.contactsView).adapter = adapter
        // 检查联系人读取权限
        if (ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.READ_CONTACTS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // 申请权限
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.READ_CONTACTS),
                1
            )
        } else {
            // 已有权限，直接读取联系人
            readContacts()
        }
    }
    // 处理权限请求结果
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            1 -> {
                if (grantResults.isNotEmpty() &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED
                ) {
                    readContacts()
                } else {
                    Toast.makeText(this, "您拒绝了联系人访问权限", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    // 读取联系人方法
    private fun readContacts() {
        // 查询联系人数据
        contentResolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            null, null, null, null
        )?.apply {
            while (moveToNext()) {
                val displayNameIndex = getColumnIndex(Phone.DISPLAY_NAME)
                val displayName =
                    if (displayNameIndex >= 0) getString(displayNameIndex) else "Unknown"
                // 获取联系人姓名
                val numberIndex = getColumnIndex(Phone.NUMBER)
                val number = if (numberIndex >= 0) getString(numberIndex) else "No number"
                contactsList.add("$displayName\n$number")
            }
            adapter.notifyDataSetChanged()
            close()
        }
    }
}

