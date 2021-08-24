package com.lilcode.example.sendbroadcast

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    var receiver: BroadcastReceiver? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configureReceiver()
    }

    // 리시버에 수신할 액션 필터를 추가함.
    private fun configureReceiver() {
        val filter = IntentFilter()
        filter.addAction("com.lilcode.example.sendbroadcast")
        receiver = MyReceiver()
        registerReceiver(receiver, filter)
    }

    // 브로드캐스트 인텐트 생성 및 전송
    fun broadcastIntent(view: View) {
        val intent = Intent()
        intent.action = "com.lilcode.example.sendbroadcast" // 수신자에서는 해당 액션과 일치하는 액션 필요.
        intent.flags = Intent.FLAG_INCLUDE_STOPPED_PACKAGES
        sendBroadcast(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver)
    }
}