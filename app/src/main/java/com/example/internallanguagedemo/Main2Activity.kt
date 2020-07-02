package com.example.internallanguagedemo

import android.os.Bundle
import com.example.plugin.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        btnChangeSkinCn.setOnClickListener {
            changeSkin(MyApp.skinPathList[0])
        }

        btnChangeSkinCnTw.setOnClickListener {
            changeSkin(MyApp.skinPathList[1])
        }

        btnChangeSkinEn.setOnClickListener {
            changeSkin(MyApp.skinPathList[2])
        }
    }
}