package com.example.internallanguagedemo

import android.os.Bundle
import com.example.plugin.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnChangeSkin.setOnClickListener {
            changeSkin(MyApp.pluginPath)
        }
    }
}