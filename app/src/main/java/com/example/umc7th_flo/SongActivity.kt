package com.example.umc7th_flo

import android.graphics.PorterDuff
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.umc7th_flo.databinding.ActivitySongBinding

class SongActivity : AppCompatActivity() {

    //소괄호 : 클래스를 다른 클래스로 상속을 진행할 때는 소괄호를 넣어줘야 한다.

    //전역 변수
    lateinit var binding : ActivitySongBinding

    private var isRepeatModeActive = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySongBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 둘 다 존재 한다면 ~
        if(intent.hasExtra("title") && intent.hasExtra("singer")){
            binding.songMusicTitleTv.text = intent.getStringExtra("title")
            binding.songSingerNameTv.text = intent.getStringExtra("singer")
        }

        binding.songDownIb.setOnClickListener {
            finish()
        }

        binding.songMiniplayerIv.setOnClickListener {
            setPlayerStatus(false)
        }

        binding.songPauseIv.setOnClickListener {
            setPlayerStatus(true)
        }

        binding.songRepeatIv.setOnClickListener {
            toggleRepeatMode()
        }
    }

    private fun setPlayerStatus(isPlaying: Boolean) {
        if (isPlaying) {
            binding.songMiniplayerIv.visibility = View.VISIBLE
            binding.songPauseIv.visibility = View.GONE
        } else {
            binding.songMiniplayerIv.visibility = View.GONE
            binding.songPauseIv.visibility = View.VISIBLE
        }
    }

    private fun toggleRepeatMode() {
        if (isRepeatModeActive) {
            // 반복 모드가 꺼져 있을 때 - 기본 색상으로 변경
            binding.songRepeatIv.colorFilter = null;
        } else {
            // 반복 모드가 켜져 있을 때 - 파란색으로 변경
            binding.songRepeatIv.setColorFilter(android.graphics.Color.BLUE, PorterDuff.Mode.SRC_IN) // 파란색 적용
        }
        isRepeatModeActive = !isRepeatModeActive // 상태 반전
    }


}