package com.gina.gienamobile.domain.di

import com.gina.gienamobile.domain.GetCardInteractor
import org.koin.dsl.module

val interactorModule = module {

    factory { GetCardInteractor(get(), get()) }
}