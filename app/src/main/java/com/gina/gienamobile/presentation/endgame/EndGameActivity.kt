package com.gina.gienamobile.presentation.endgame

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.gina.gienamobile.R
import com.gina.gienamobile.presentation.endgame.END_TYPE.BAD
import com.gina.gienamobile.presentation.endgame.END_TYPE.GOOD
import com.gina.gienamobile.presentation.endgame.END_TYPE.NORMAL

class EndGameActivity : AppCompatActivity(R.layout.activity_end_game) {
    companion object {

        const val ARG_END_TYPE = "ArgEndType"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val endTypeArg = intent.getIntExtra(ARG_END_TYPE, -1)
        if (endTypeArg != -1) {
            val endType = END_TYPE.values().find { it.ordinal == endTypeArg }
            if (endType != null) {
                showEnding(endType)
            }
        }
    }

    private fun showEnding(endType: END_TYPE) {
        val rootView = findViewById<FrameLayout>(R.id.flRoot)
        when (endType) {
            BAD -> rootView.background = resources.getDrawable(R.drawable.bg_bad_ending)
            NORMAL -> rootView.background = resources.getDrawable(R.drawable.bg_normal_ending)
            GOOD -> rootView.background = resources.getDrawable(R.drawable.bg_good_ending)
        }
    }
}