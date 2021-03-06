package com.example.internallanguagedemo

import android.content.Intent
import android.os.Bundle
import com.example.plugin.base.BaseActivity
import com.example.plugin.base.LanguageSetting
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnChangeSkinCn.setOnClickListener {
            changeSkin(MyApp.skinPathList[0])
        }

        btnChangeSkinCnTw.setOnClickListener {
            changeSkin(MyApp.skinPathList[1])
        }

        btnChangeSkinEn.setOnClickListener {
            changeSkin(MyApp.skinPathList[2])
        }
        btnJump.setOnClickListener {
            val intent = Intent(this, Main2Activity::class.java)
            startActivity(intent)
        }
    }
}