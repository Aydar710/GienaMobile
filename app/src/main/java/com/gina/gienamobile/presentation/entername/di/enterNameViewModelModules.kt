package com.gina.gienamobile.presentation.entername.di

import com.gina.gienamobile.presentation.entername.EnterNameViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val enterNameViewModelModule = module {

    viewModel { EnterNameViewModel(get(), get()) }
}