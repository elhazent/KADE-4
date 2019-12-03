package com.elhazent.education.kade4.network

import com.elhazent.education.kade4.BuildConfig
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit


class InitRetrofit{

    companion object{
        fun providerLogginInterceptor(): HttpLoggingInterceptor {
            val loggingInterceptor = HttpLoggingInterceptor()
            if (BuildConfig.DEBUG) {
                loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            } else {
                loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE)
            }

            return loggingInterceptor
        }


        fun providerOkHttpClient(): OkHttpClient {
            return OkHttpClient.Builder()
                .addInterceptor(providerLogginInterceptor())
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build()

        }


        fun providerRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(providerOkHttpClient())
                .build()
        }

        fun providerApiService(): ApiService {
            return providerRetrofit().create<ApiService>(ApiService::class.java)
        }
    }

}