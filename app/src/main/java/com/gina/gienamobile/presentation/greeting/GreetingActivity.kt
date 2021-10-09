package com.gina.gienamobile.presentation.greeting

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.gina.gienamobile.R

class GreetingActivity : AppCompatActivity(R.layout.activity_greeting) {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        findViewById<ConstraintLayout>(R.id.clRoot).setOnClickListener {

        }
    }
}