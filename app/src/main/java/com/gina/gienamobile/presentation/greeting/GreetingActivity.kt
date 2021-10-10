package com.gina.gienamobile.presentation.greeting

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.gina.gienamobile.R
import com.gina.gienamobile.presentation.entername.EnterNameActivity

class GreetingActivity : AppCompatActivity(R.layout.activity_greeting) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        findViewById<ConstraintLayout>(R.id.clRoot).setOnClickListener {
            startActivity(Intent(this, EnterNameActivity::class.java))
        }
    }
}