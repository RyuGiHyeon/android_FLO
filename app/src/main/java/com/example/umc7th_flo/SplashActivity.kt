//package com.example.umc7th_flo
//
//import android.content.Intent
//import android.os.Bundle
//import android.os.Handler
//import android.os.Looper
//import androidx.appcompat.app.AppCompatActivity
//import com.example.umc7th_flo.databinding.ActivitySplashBinding
//
//class SplashActivity : AppCompatActivity() {
//
//    lateinit var binding : ActivitySplashBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivitySplashBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        initializeApp();
//    }
//
//    private fun initializeApp() {
//        Handler(Looper.getMainLooper()).postDelayed({
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
//            finish()    // SplashActivity 종료
//        }, 2000) // 로딩 작업이 끝난 후 2초 동안 Splash 화면을 보여줍니다.
//    }
//
//}