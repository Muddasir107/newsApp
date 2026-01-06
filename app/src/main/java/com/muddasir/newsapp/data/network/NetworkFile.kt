package com.muddasir.newsapp.data.network

import com.muddasir.newsapp.constants.NetworkConstants
import com.muddasir.newsapp.data.network.remoteapis.RemoteApiService
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

@Module
@InstallIn(SingletonComponent::class)
object NetworkFile {
    @Provides
    fun provideBaseUrl(): String = NetworkConstants.BASE_URL


    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().setLevel(
        HttpLoggingInterceptor.Level.BODY
    )

    @Provides
    fun provideOkHttpClient(logger: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder().addNetworkInterceptor(logger).build()

    @Provides
    fun provideConvertorFactory(): Converter.Factory= GsonConverterFactory.create()


    @Provides
    fun provideRetrofit(baseUrl:String,converter: Converter.Factory,client: OkHttpClient): Retrofit = Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(converter).client(client).build()

    @Provides
    fun provideRemoteApiService(retrofit: Retrofit): RemoteApiService = retrofit.create<RemoteApiService>(
        RemoteApiService::class.java)

}