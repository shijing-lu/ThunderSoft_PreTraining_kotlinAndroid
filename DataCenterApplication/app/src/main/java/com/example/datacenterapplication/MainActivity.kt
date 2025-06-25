package com.example.datacenterapplication

import android.content.ContentValues
import android.content.Intent
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.core.content.contentValuesOf

class MainActivity : ComponentActivity() {
    private val datacenterList = ArrayList<String>()
    private lateinit var adapter: ArrayAdapter<String>
    var bookId: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)
//添加数据按钮
        findViewById<Button>(R.id.add_data).setOnClickListener {
            val uri = Uri.parse("content://com.example.datacenter.provider/book")
            val values = contentValuesOf("name" to "A Clash of Kings",
                "author" to "George Martin", "pages" to 1040, "price" to 22.85)
            val newUri = contentResolver.insert(uri, values)
            bookId = newUri?.pathSegments?.get(1)
        }
//        查询数据
        findViewById<Button>(R.id.query_data).setOnClickListener {
            val uri = Uri.parse("content://com.example.datacenter.provider/book")

            // 执行查询并获取Cursor对象
            val cursor: Cursor? = contentResolver.query(uri, null, null, null, null)

            // 检查cursor是否为null
            if (cursor == null) {
                // 查询返回null时的处理
                Log.e("MainActivity", "Query failed: returned null cursor")
                Toast.makeText(this, "数据库查询失败，请检查ContentProvider配置", Toast.LENGTH_SHORT).show()
            } else {
                try {
                    // 检查cursor是否为空
                    if (cursor.count == 0) {
                        Log.d("MainActivity", "Query succeeded but no data found")
                        Toast.makeText(this, "未找到图书数据", Toast.LENGTH_SHORT).show()
                    } else {
                        Log.d("MainActivity", "Query succeeded with ${cursor.count} records")

                        // 遍历游标获取数据
                        while (cursor.moveToNext()) {
                            val name = cursor.getString(cursor.getColumnIndex("name"))
                            val author = cursor.getString(cursor.getColumnIndex("author"))
                            val pages = cursor.getInt(cursor.getColumnIndex("pages"))
                            val price = cursor.getDouble(cursor.getColumnIndex("price"))

                            Log.d("MainActivity", "book name is $name")
                            Log.d("MainActivity", "book author is $author")
                            Log.d("MainActivity", "book pages is $pages")
                            Log.d("MainActivity", "book price is $price")
                        }
                    }
                } catch (e: Exception) {
                    // 处理可能的异常（如列名错误）
                    Log.e("MainActivity", "Error processing cursor", e)
                    Toast.makeText(this, "数据处理出错: ${e.message}", Toast.LENGTH_SHORT).show()
                } finally {
                    // 确保无论如何都关闭游标
                    cursor.close()
                }
            }
        }

        Log.d("datacenter","coming")
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, datacenterList)
        findViewById<ListView>(R.id.datacenter).adapter = adapter
        Log.d("datacenter1","coming")
        datacenterList.add("这是测试数据")
        val uri=Uri.parse("content://com.example.datacenter.provider/book")
        contentResolver.query(uri, null, null, null, null)?.apply {
            while (moveToNext()) {
                val name = getString(getColumnIndex("name"))
                val author = getString(getColumnIndex("author"))
                val pages = getInt(getColumnIndex("pages"))
                val price = getDouble(getColumnIndex("price"))
                Log.d("MainActivity", "book name is $name")
                Log.d("MainActivity", "book author is $author")
                Log.d("MainActivity", "book pages is $pages")
                Log.d("MainActivity", "book price is $price")
                datacenterList.add("$name   $author   $pages   $price")
            }
            close()
        }
        adapter.notifyDataSetChanged()
    }

}