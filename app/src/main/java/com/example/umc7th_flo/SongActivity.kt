package com.example.umc7th_flo

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.umc7th_flo.databinding.ActivitySongBinding

class SongActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySongBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySongBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initClickListener()

        initSong()
    }

    private fun initClickListener() {
        binding.songDownIb.setOnClickListener {
            finish()
        }
    }

    private fun initSong() {
        val editor = getSharedPreferences("song", MODE_PRIVATE).edit()
        editor.putString("title",binding.songTitleTv.text.toString())
        editor.putString("singer",binding.songSingerNameTv.text.toString())
        editor.apply()

    }

}