package com.example.umc7th_flo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.umc7th_flo.databinding.FragmentAlbumBinding
import com.google.android.material.tabs.TabLayoutMediator
import com.google.gson.Gson

class AlbumFragment : Fragment() {

    lateinit var binding: FragmentAlbumBinding
    private var gson: Gson = Gson()

    private val information = arrayListOf("수록곡", "상세정보", "영상")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAlbumBinding.inflate(inflater,container,false)

        binding.albumBackIv.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.main_frm, HomeFragment())
                .commitAllowingStateLoss()
        }

        val albumAdapter = AlbumVPAdapter(this)
        binding.albumContentVp.adapter = albumAdapter
        TabLayoutMediator(binding.albumContentTb, binding.albumContentVp) {
            tab, position ->
            tab.text = information[position]
        }.attach()

        val albumJson = arguments?.getString("album")
        val album = gson.fromJson(albumJson, Album::class.java)
        setInit(album)

//        binding.songLalacLayout.setOnClickListener {
//            Toast.makeText(activity, "LILAC", Toast.LENGTH_SHORT).show()
//        }
//
//        binding.songFluLayout.setOnClickListener {
//            Toast.makeText(activity,"FLU", Toast.LENGTH_SHORT).show()
//        }
//
//        binding.songCoinLayout.setOnClickListener {
//            Toast.makeText(activity,"Coin", Toast.LENGTH_SHORT).show()
//        }
//
//        binding.songSpringLayout.setOnClickListener {
//            Toast.makeText(activity,"봄 안녕 봄", Toast.LENGTH_SHORT).show()
//        }
//
//        binding.songCelebrityLayout.setOnClickListener {
//            Toast.makeText(activity,"Celebrity", Toast.LENGTH_SHORT).show()
//        }
//
//        binding.songSingLayout.setOnClickListener {
//            Toast.makeText(activity,"돌림노래 (Feat. DEAN)", Toast.LENGTH_SHORT).show()
//        }

        return binding.root
    }

    private fun setInit(album: Album){
        binding.albumAlbumIv.setImageResource(album.coverImg!!)
        binding.albumMusicTitleTv.text = album.title.toString()
        binding.albumSingerNameTv.text = album.singer.toString()

    }

}