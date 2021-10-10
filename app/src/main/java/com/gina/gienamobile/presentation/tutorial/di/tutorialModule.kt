package com.gina.gienamobile.presentation.tutorial.di

import com.gina.gienamobile.presentation.tutorial.TutorialViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val tutorialModule = module {

    viewModel { TutorialViewModel(get()) }
}
