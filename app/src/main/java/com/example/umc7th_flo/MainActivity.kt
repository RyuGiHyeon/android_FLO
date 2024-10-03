package com.example.umc7th_flo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.umc7th_flo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private var song: Song = Song()
    private var recentPosition = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initBottomNavigation()

        binding.mainPlayerCl.setOnClickListener {
            val spf = getSharedPreferences("song", MODE_PRIVATE)
            binding.mainMiniplayerTitleTv.text = spf.getString("title","")
            binding.mainMiniplayerSingerTv.text = spf.getString("singer","")

            val intent = Intent(this,SongActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initBottomNavigation(){

        supportFragmentManager.beginTransaction()
            .replace(R.id.main_frm, HomeFragment())
            .commitAllowingStateLoss()

        binding.mainBnv.setOnItemSelectedListener{ item ->
            when (item.itemId) {

                R.id.homeFragment -> {
                    supportFragmentManager.beginTransaction()
                        .setCustomAnimations(
                            R.anim.slide_left_in,
                            R.anim.anim_fade_out
                        )
                        .replace(R.id.main_frm, HomeFragment())
                        .commitAllowingStateLoss()
                    recentPosition = 0
                    return@setOnItemSelectedListener true
                }

                R.id.lookFragment -> {
                    if (recentPosition < 1) {
                        supportFragmentManager.beginTransaction()
                            .setCustomAnimations(
                                R.anim.anim_slide_right_in,
                                R.anim.anim_fade_out
                            )
                            .replace(R.id.main_frm, LookFragment())
                            .commitAllowingStateLoss()
                    } else {
                        supportFragmentManager.beginTransaction()
                            .setCustomAnimations(
                                R.anim.slide_left_in,
                                R.anim.anim_fade_out
                            )
                            .replace(R.id.main_frm, LookFragment())
                            .commitAllowingStateLoss()
                    }
                    recentPosition = 1
                    return@setOnItemSelectedListener true
                }

                R.id.searchFragment -> {
                    if (recentPosition < 2) {
                        supportFragmentManager.beginTransaction()
                            .setCustomAnimations(
                                R.anim.anim_slide_right_in,
                                R.anim.anim_fade_out
                            )
                            .replace(R.id.main_frm, SearchFragment())
                            .commitAllowingStateLoss()
                    } else {
                        supportFragmentManager.beginTransaction()
                            .setCustomAnimations(
                                R.anim.slide_left_in,
                                R.anim.anim_fade_out
                            )
                            .replace(R.id.main_frm, SearchFragment())
                            .commitAllowingStateLoss()
                    }
                    recentPosition = 2
                    return@setOnItemSelectedListener true
                }

                R.id.lockerFragment -> {
                    supportFragmentManager.beginTransaction()
                        .setCustomAnimations(
                            R.anim.anim_slide_right_in,
                            R.anim.anim_fade_out
                        )
                        .replace(R.id.main_frm, LockerFragment())
                        .commitAllowingStateLoss()
                    recentPosition = 3
                    return@setOnItemSelectedListener true
                }
            }
            false
        }
    }
}