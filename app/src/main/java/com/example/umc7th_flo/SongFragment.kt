package com.example.umc7th_flo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.umc7th_flo.databinding.FragmentSongBinding

class SongFragment : Fragment() {

    private lateinit var binding: FragmentSongBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSongBinding.inflate(inflater,container,false)

        binding.songMixoffTg.setOnClickListener {
            setSongMix(false)
        }
        binding.songMixonTg.setOnClickListener {
            setSongMix(true)
        }

        return binding.root

    }

    private fun setSongMix(isPlaying : Boolean) {
        if(isPlaying){
            binding.songMixoffTg.visibility = View.VISIBLE
            binding.songMixonTg.visibility = View.GONE
        }
        else {
            binding.songMixoffTg.visibility = View.GONE
            binding.songMixonTg.visibility = View.VISIBLE
        }
    }

}