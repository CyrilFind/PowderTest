package com.powder.powdertest

import android.os.Build
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val videos = resources.openRawResource(R.raw.videos).bufferedReader().use {
            kotlinxJson.decodeFromString(ListSerializer(Video.serializer()), it.readText())
        }
        val videoAdapter = VideoAdapter(this, videos)
        viewPager2_mainActivity.adapter = videoAdapter
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
    }

}

val kotlinxJson = Json {
    coerceInputValues = true
    ignoreUnknownKeys = true
    isLenient = true
}
