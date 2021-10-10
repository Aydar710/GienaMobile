package com.gina.gienamobile.presentation.endgame.di

import com.gina.gienamobile.presentation.endgame.EndGameViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val endGameModule = module {

    viewModel { EndGameViewModel(get()) }
}