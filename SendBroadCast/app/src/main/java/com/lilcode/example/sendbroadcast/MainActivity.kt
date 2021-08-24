package com.lilcode.example.sendbroadcast

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // 브로드캐스트 인텐트 생성 및 전송
    fun broadcastIntent(view: View) {
        val intent = Intent()
        intent.action = "com.lilcode.example.sendbroadcast" // 수신자에서는 해당 액션과 일치하는 액션 필요.
        intent.flags = Intent.FLAG_INCLUDE_STOPPED_PACKAGES
        sendBroadcast(intent)
    }
}