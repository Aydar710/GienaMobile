package com.gina.gienamobile.presentation.endgame

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
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

        setVtbInvestmentsBtnClickListener()
    }

    private fun setVtbInvestmentsBtnClickListener() {
        findViewById<Button>(R.id.btnInvestments).setOnClickListener {
            val uri: Uri = Uri.parse("https://play.google.com/store/apps/details?id=ru.vtb.invest&hl=ru&gl=US")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }
    }

    private fun showEnding(endType: END_TYPE) {
        val rootView = findViewById<ConstraintLayout>(R.id.flRoot)
        when (endType) {
            BAD -> rootView.background = resources.getDrawable(R.drawable.bg_bad_ending)
            NORMAL -> rootView.background = resources.getDrawable(R.drawable.bg_normal_ending)
            GOOD -> rootView.background = resources.getDrawable(R.drawable.bg_good_ending)
        }
    }
}