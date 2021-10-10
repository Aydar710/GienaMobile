package com.gina.gienamobile.data.di

import com.gina.gienamobile.data.repository.AnalyticsRepository
import com.gina.gienamobile.data.repository.AnalyticsRepositoryImpl
import com.gina.gienamobile.data.repository.CardRepository
import com.gina.gienamobile.data.repository.CardRepositoryImpl
import com.gina.gienamobile.data.repository.UserLocalRepository
import com.gina.gienamobile.data.repository.UserLocalRepositoryMockImpl
import com.gina.gienamobile.data.repository.UserRepository
import com.gina.gienamobile.data.repository.UserRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {

    factory<CardRepository> { CardRepositoryImpl(get(), get()) }

    factory<AnalyticsRepository> { AnalyticsRepositoryImpl(get()) }

    single<UserLocalRepository> { UserLocalRepositoryMockImpl() }

    single<UserRepository> { UserRepositoryImpl(get(), get()) }
}