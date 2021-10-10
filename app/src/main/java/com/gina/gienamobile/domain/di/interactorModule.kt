package com.gina.gienamobile.domain.di

import com.gina.gienamobile.domain.interactors.GetCardInteractor
import com.gina.gienamobile.domain.interactors.SendUserOpenedLinkAnalyticsEvent
import org.koin.dsl.module

val interactorModule = module {

    factory { GetCardInteractor(get(), get()) }

    factory { SendUserOpenedLinkAnalyticsEvent(get(), get()) }
}