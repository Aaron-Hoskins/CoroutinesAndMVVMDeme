package com.examples.coding.rxjavademo.datasource.remote.retrofit

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL_CHUCK_NORRIS = "https://api.icndb.com/"
object RetrofitHelper {
    val retrofitInstance : Retrofit
    init {
        retrofitInstance = Retrofit
            .Builder()
            .client(getClient())
            .baseUrl(BASE_URL_CHUCK_NORRIS)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }

    private fun getClient() : OkHttpClient{
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }
}