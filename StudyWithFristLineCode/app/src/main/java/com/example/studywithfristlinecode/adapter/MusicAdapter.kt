package com.example.studywithfristlinecode.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.studywithfristlinecode.R
import com.example.studywithfristlinecode.entity.Music

class MusicAdapter(activity: Activity, val resourceId: Int, data: List<Music>) :
    ArrayAdapter<Music>(activity, resourceId, data) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = LayoutInflater.from(context).inflate(resourceId, parent, false)
        val musicImage: ImageView = view.findViewById(R.id.musicImage)
        val musicName: TextView = view.findViewById(R.id.musicName)
        val musicAuthor: TextView = view.findViewById(R.id.musicAuthor)
        val musicTime: TextView = view.findViewById(R.id.musicTime)

        val music = getItem(position) // 获取当前项的Fruit实例
        if (music != null) {
            musicImage.setImageResource(music.imageId)
            musicName.text = music.name
            musicAuthor.text=music.author
            musicTime.text=music.time
        }
        return view

    }
}