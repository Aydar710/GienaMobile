package com.gina.gienamobile

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout

class VatabeView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attributeSet, defStyleAttr) {

    init {
        inflate(context, R.layout.view_vatabe, this)
    }

    private fun increaseBubbleHeight() {
        val v = findViewById<ImageView>(R.id.ivBuble)
        val lp = ConstraintLayout.LayoutParams(v.width, v.height * 2)
        v.layoutParams = lp
    }
}