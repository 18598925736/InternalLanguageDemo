package com.example.internallanguagedemo

import android.app.Application
import com.example.plugin.skin.SkinEngine.Companion.instance
import com.example.plugin.util.AssetUtil

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        //初始化换肤引擎
        instance.init(this)
        pluginPath = AssetUtil.copyAssetToCache(this, Const.PLUGIN_FILE_NAME)
    }

    companion object {
        lateinit var pluginPath: String
    }
}