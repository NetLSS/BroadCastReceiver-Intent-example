# 브로드캐스트 리시버, 인텐트 사용 데모 프로젝트

## 브로드케스트 수신자 생성

- app-java-프로젝트패키지-New-Other-Broadcast Receiver 선택
- - Exported, Enabled 체크후 생성 (다른 앱에서 전송된 메세지 수신 가능하도록)

## 브로드케스트 수신자 등록

```kotlin
    // 리시버에 수신할 액션 필터를 추가함.
    private fun configureReceiver() {
        val filter = IntentFilter()
        filter.addAction("com.lilcode.example.sendbroadcast")
        filter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED") // 시스템 전원 연결 브로드캐스트 리스닝 해보기
        receiver = MyReceiver()
        registerReceiver(receiver, filter)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver)
    }
```

## 브로드케스트 인텐트 생성 및 전송

```kotlin
    // 브로드캐스트 인텐트 생성 및 전송
    fun broadcastIntent(view: View) {
        val intent = Intent()
        intent.action = "com.lilcode.example.sendbroadcast" // 수신자에서는 해당 액션과 일치하는 액션 필요.
        intent.flags = Intent.FLAG_INCLUDE_STOPPED_PACKAGES
        sendBroadcast(intent)
    }
```

## 리시버 클래스

```kotlin
class MyReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val message = "Broadcast intent detected " + intent.action
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}
```