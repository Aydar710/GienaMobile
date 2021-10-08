package com.gina.gienamobile.data.di

import com.gina.gienamobile.BuildConfig
import com.gina.gienamobile.data.service.GienaService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module{
    single { provideOkHttpClient() }
    single { provideRetrofit(get(), get()) }
    single { provideGson() }
    single { get<Retrofit>().create(GienaService::class.java) }
}

private fun provideRetrofit(
    okHttpClient: OkHttpClient,
    gson: Gson
): Retrofit {
    return Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(BuildConfig.API_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()
}

private fun provideOkHttpClient(): OkHttpClient {
    return with(OkHttpClient.Builder()) {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        addInterceptor(loggingInterceptor)
        build()
    }
}

private fun provideGson(): Gson {
    return GsonBuilder()
        .serializeNulls()
        .create()
}