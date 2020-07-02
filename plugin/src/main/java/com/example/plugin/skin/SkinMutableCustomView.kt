package com.example.plugin.skin

import android.content.Context
import android.util.AttributeSet
import android.view.View

/**
 * 皮肤可变的自定义View
 */
class SkinMutableCustomView : View {
    constructor(context: Context?) : super(context) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(
        context,
        attrs
    ) {
    }

    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int
    ) : super(context, attrs, defStyleAttr) {
    }
}