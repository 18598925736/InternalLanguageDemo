package com.example.internallanguagedemo

import android.app.Application
import com.example.plugin.base.LanguageSetting
import com.example.plugin.skin.SkinEngine.Companion.instance

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        skinPathList = instance.init(this, skinArr) //初始化换肤引擎
    }

    companion object {
        lateinit var skinPathList: List<String>
        val skinArr =
            listOf(LanguageSetting.SKIN_CN, LanguageSetting.SKIN_CN_TW, LanguageSetting.SKIN_EN)
    }
}