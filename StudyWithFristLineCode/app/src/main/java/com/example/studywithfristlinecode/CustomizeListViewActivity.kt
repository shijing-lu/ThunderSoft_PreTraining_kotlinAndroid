package com.example.studywithfristlinecode

import android.os.Bundle
import android.widget.ListView
import androidx.activity.ComponentActivity
import com.example.studywithfristlinecode.adapter.MusicAdapter
import com.example.studywithfristlinecode.entity.Music

class CustomizeListViewActivity : ComponentActivity() {
    private val MusicList = ArrayList<Music>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.customizelistview_layout)
        initMusic() // 初始化水果数据
        val adapter = MusicAdapter(this, R.layout.music_item, MusicList)
        findViewById<ListView>(R.id.CustomizeListView).adapter = adapter
    }
    private fun initMusic() {
        repeat(2) {
            MusicList.add(Music("七里香", "周杰伦", "4:59", R.drawable.jay_chou_qilixiang))
            MusicList.add(Music("青花瓷", "周杰伦", "4:33", R.drawable.jay_chou_qinghuaci))
            MusicList.add(Music("晴天", "周杰伦", "5:18", R.drawable.jay_chou_qingtian))
            MusicList.add(Music("夜曲", "周杰伦", "3:46", R.drawable.jay_chou_yequ))
            MusicList.add(Music("稻香", "周杰伦", "3:43", R.drawable.jay_chou_daoxiang))
            MusicList.add(Music("告白气球", "周杰伦", "3:35", R.drawable.jay_chou_gaobaiqiqiu))
            MusicList.add(Music("双截棍", "周杰伦", "3:22", R.drawable.jay_chou_shuangjiegun))
            MusicList.add(Music("东风破", "周杰伦", "5:15", R.drawable.jay_chou_dongfengpo))
            MusicList.add(Music("简单爱", "周杰伦", "4:30", R.drawable.jay_chou_jiandana))
            MusicList.add(Music("听妈妈的话", "周杰伦", "4:24", R.drawable.jay_chou_tingmamadehua))
            MusicList.add(Music("龙卷风", "周杰伦", "4:08", R.drawable.jay_chou_longjuanfeng))
            MusicList.add(Music("菊花台", "周杰伦", "4:11", R.drawable.jay_chou_juhuatai))
            MusicList.add(Music("发如雪", "周杰伦", "4:58", R.drawable.jay_chou_faruxue))
            MusicList.add(Music("一路向北", "周杰伦", "4:55", R.drawable.jay_chou_yiluxiangbei))
            MusicList.add(
                Music(
                    "珊瑚海",
                    "周杰伦 feat. Lara",
                    "4:16",
                    R.drawable.jay_chou_shanhuhai
                )
            )
        }
    }
}

