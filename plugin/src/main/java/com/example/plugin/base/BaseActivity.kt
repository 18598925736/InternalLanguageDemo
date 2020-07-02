package com.example.plugin.base

import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.plugin.skin.SkinEngine
import com.example.plugin.skin.SkinFactory
import java.io.File

/**
 * 把换肤的功能定义在这里
 */
open class BaseActivity : AppCompatActivity() {

    private val REQUEST_EXTERNAL_STORAGE = 1
    private val PERMISSIONS_STORAGE = arrayOf(
        "android.permission.READ_EXTERNAL_STORAGE",
        "android.permission.WRITE_EXTERNAL_STORAGE"
    ) //内存读写的权限，现在要动态申请了？


    /**
     * 申请权限，为了要把外部文件写入到 手机内存中
     *
     * @param activity
     */
    open fun verifyStoragePermissions(activity: AppCompatActivity) {
        try {
            //检测是否有写的权限
            val permission: Int =
                ActivityCompat.checkSelfPermission(activity, PERMISSIONS_STORAGE[1])
            if (permission != PackageManager.PERMISSION_GRANTED) {
                // 没有写的权限，去申请写的权限，会弹出对话框
                ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
                )
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private var mSkinFactory: SkinFactory = SkinFactory()
    override fun onCreate(savedInstanceState: Bundle?) {
        // TODO: 关键点1：hook（劫持）系统创建view的过程
        mSkinFactory.setDelegate(delegate)
        val layoutInflater = LayoutInflater.from(this)
        Log.d("layoutInflaterTag", layoutInflater.toString())
        layoutInflater.factory2 = mSkinFactory
        super.onCreate(savedInstanceState)
        verifyStoragePermissions(this) //申请权限。。
    }

    /**
     * 创建完成但是还不可以交互
     */
    override fun onStart() {
        super.onStart()
    }

    /**
     * 等控件创建完成并且可交互之后，再换肤
     */
    override fun onResume() {
        super.onResume()
        Log.d("LanguageSetting", "${LanguageSetting.currentLanguageSkinPath}")
        if (LanguageSetting.currentLanguageSkinPath.isNullOrEmpty()) return
        changeSkin(LanguageSetting.currentLanguageSkinPath)
    }

    fun changeSkin(path: String) {

        LanguageSetting.currentLanguageSkinPath = path
        SkinEngine.instance.load(path)
        mSkinFactory.changeSkin()

    }

    companion object {
        const val STATE_EN = "en"
        const val STATE_CN = "cn"
        const val STATE_CN_TW = "cn_tw"
    }

    var languageState = STATE_CN

}