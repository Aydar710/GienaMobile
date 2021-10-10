package com.gina.gienamobile.presentation.segmentation

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.ImageView
import com.gina.gienamobile.R
import com.gina.gienamobile.R.layout

class ClassView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attributeSet, defStyleAttr) {

    init {
        inflate(context, layout.class_view, this)
    }

    fun markAsSelected() {
        findViewById<FrameLayout>(R.id.flSelection).background = resources.getDrawable(R.drawable.bg_class)
    }

    fun markAsUnSelected() {
        findViewById<FrameLayout>(R.id.flSelection).background = null
    }

    fun setClassImage(imageRes: Int) {
        findViewById<ImageView>(R.id.ivClass).setImageDrawable(resources.getDrawable(imageRes))
    }
}