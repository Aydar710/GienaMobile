package com.gina.gienamobile.presentation.main

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.gina.gienamobile.R
import com.gina.gienamobile.R.drawable
import com.gina.gienamobile.R.layout

class VatabeView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attributeSet, defStyleAttr) {

    private val tvSpeechView: TextView by lazy { findViewById(R.id.tvSpeech) }
    private val ivVatabe: ImageView by lazy { findViewById(R.id.ivVatabe) }

    init {
        inflate(context, layout.view_vatabe, this)
    }

    fun setSpeech(speech: String) {
        tvSpeechView.text = speech
    }

    fun setGladnessMood() {
        ivVatabe.setImageResource(drawable.ic_vatabe_gladness)
    }

    fun setShockMood() {
        ivVatabe.setImageResource(drawable.ic_vatabe_shock)
    }

    private fun increaseBubbleHeight() {
        val v = findViewById<ImageView>(R.id.ivBuble)
        val lp = ConstraintLayout.LayoutParams(v.width, v.height * 2)
        v.layoutParams = lp
    }
}