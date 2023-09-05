package com.darvishiyan.data.di

import com.darvishiyan.data.BuildConfig
import com.darvishiyan.data.remote.ApiService
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal class NetworkModule {
    private val URL = "https://m.mobile.de/svc/a/"

    @Singleton
    @Provides
    @Named("loggerInterceptor")
    fun loggerInterceptorProvider(): Interceptor =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    @Singleton
    @Provides
    fun okHttpClientProvider(
        @Named("loggerInterceptor") debuggingInterceptor: Interceptor,
    ): OkHttpClient = OkHttpClient().newBuilder()
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(10, TimeUnit.SECONDS)
        .connectTimeout(10, TimeUnit.SECONDS)
        .apply { if (BuildConfig.DEBUG) addInterceptor(debuggingInterceptor) }
        .build()

    @Singleton
    @Provides
    fun converterFactoryProvider(): Converter.Factory = GsonConverterFactory.create(GsonBuilder().setPrettyPrinting().create())

    @Singleton
    @Provides
    fun retrofitProvider(
        client: OkHttpClient,
        converterFactory: Converter.Factory,
    ): Retrofit = Retrofit.Builder()
        .baseUrl(URL)
        .client(client)
        .addConverterFactory(converterFactory)
        .build()

    @Singleton
    @Provides
    fun apiServiceProvider(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)
}
