package com.example.umc7th_flo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.umc7th_flo.databinding.FragmentSongBinding

class SongFragment : Fragment() {

    lateinit var binding : FragmentSongBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSongBinding.inflate(inflater, container, false)

        binding.songMixoffTg.setOnClickListener {
            setMixStatus(true)
        }
        binding.songMixonTg.setOnClickListener {
            setMixStatus(false)
        }

        return binding.root
    }

    private fun setMixStatus(isMixing: Boolean) {
        if (isMixing) {
            // 믹스가 켜져 있는 경우
            binding.songMixoffTg.visibility = View.GONE // Mix Off 버튼 숨기기
            binding.songMixonTg.visibility = View.VISIBLE // Mix On 버튼 보이기
        } else {
            // 믹스가 꺼져 있는 경우
            binding.songMixonTg.visibility = View.GONE // Mix On 버튼 숨기기
            binding.songMixoffTg.visibility = View.VISIBLE // Mix Off 버튼 보이기
        }
    }
}