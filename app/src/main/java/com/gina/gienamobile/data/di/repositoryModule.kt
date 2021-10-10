package com.gina.gienamobile.data.di

import com.gina.gienamobile.data.repository.CardRepository
import com.gina.gienamobile.data.repository.CardRepositoryImpl
import com.gina.gienamobile.data.repository.UserLocalRepository
import com.gina.gienamobile.data.repository.UserLocalRepositoryMockImpl
import org.koin.dsl.module

val repositoryModule = module {

    factory<CardRepository> { CardRepositoryImpl(get()) }

    single<UserLocalRepository> { UserLocalRepositoryMockImpl() }
}