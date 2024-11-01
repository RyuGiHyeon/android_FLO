package com.example.umc7th_flo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.umc7th_flo.databinding.FragmentLockerSavedMusicBinding

class LockerSavedMusicFragment : Fragment() {

    lateinit var binding : FragmentLockerSavedMusicBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLockerSavedMusicBinding.inflate(inflater, container, false)

        return binding.root
    }
}