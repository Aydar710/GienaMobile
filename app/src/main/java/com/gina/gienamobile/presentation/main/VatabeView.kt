package com.gina.gienamobile.presentation.main

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
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
        inflate(context, layout.view_vatabe2, this)
    }

    fun setSpeech(speech: String) {
        tvSpeechView.text = speech.toShieldedString()
    }

    fun setGladnessMood() {
        ivVatabe.setImageResource(drawable.ic_vatabe_gladness)
    }

    fun setShockMood() {
        ivVatabe.setImageResource(drawable.ic_vatabe_shock)
    }

    private fun String.toShieldedString(): String {
        val works = split(" ".toRegex()).toTypedArray() // get list of works
        var line = StringBuilder()
        val result = StringBuilder()
        for (work in works) {
            if (line.length + work.length > 25) { //add line to result if it full
                result.append(line).append("\n")
                line = StringBuilder() //reset line is empty
            }
            line.append(work).append(" ")
        }
        result.append(line)
        return result.toString()
    }
}