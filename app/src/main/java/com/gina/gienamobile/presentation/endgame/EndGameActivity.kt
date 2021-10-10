package com.gina.gienamobile.presentation.endgame

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.gina.gienamobile.presentation.endgame.END_TYPE.BAD
import com.gina.gienamobile.presentation.endgame.END_TYPE.GOOD
import com.gina.gienamobile.presentation.endgame.END_TYPE.NORMAL
import org.koin.androidx.viewmodel.ext.android.viewModel

class EndGameActivity : AppCompatActivity(com.gina.gienamobile.R.layout.activity_end_game) {

    private val viewModel: EndGameViewModel by viewModel()

    companion object {

        const val ARG_END_TYPE = "ArgEndType"
        const val PLAY_MARKET_LINK = "https://play.google.com/store/apps/details?id=ru.vtb.invest&hl=ru&gl=US"
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
        findViewById<Button>(com.gina.gienamobile.R.id.btnInvestments).setOnClickListener {

            val uri: Uri = Uri.parse(PLAY_MARKET_LINK)
            val intent = Intent(Intent.ACTION_VIEW, uri)
            if (intent.resolveActivity(packageManager) != null) {
                viewModel.userOpenedLink(PLAY_MARKET_LINK)
                startActivity(intent)
            }
        }
    }

    private fun showEnding(endType: END_TYPE) {
        val rootView = findViewById<ConstraintLayout>(com.gina.gienamobile.R.id.flRoot)
        when (endType) {
            BAD -> rootView.background = resources.getDrawable(com.gina.gienamobile.R.drawable.bg_bad_ending)
            NORMAL -> rootView.background = resources.getDrawable(com.gina.gienamobile.R.drawable.bg_normal_ending)
            GOOD -> rootView.background = resources.getDrawable(com.gina.gienamobile.R.drawable.bg_good_ending)
        }
    }
}