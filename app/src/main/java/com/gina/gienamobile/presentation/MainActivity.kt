package com.gina.gienamobile.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gina.gienamobile.R.layout
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        supportActionBar?.hide()
    }
}
