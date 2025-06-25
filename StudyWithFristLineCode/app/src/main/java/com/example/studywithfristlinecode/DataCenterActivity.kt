package com.example.studywithfristlinecode


import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.activity.ComponentActivity


class DataCenterActivity : ComponentActivity() {
    private val datacenterList = ArrayList<String>()
    private lateinit var adapter: ArrayAdapter<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.datacenter_layout)

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
                datacenterList.add("$name   $author   $pages   $price")
            }
            close()
        }
        adapter.notifyDataSetChanged()

        }
    }
