package com.example.sportzinteractive.network

import com.example.sportzinteractive.model.INDNZMatchDetailsResponse
import com.example.sportzinteractive.model.SAPAKMatchDetailsResponse
import com.example.sportzinteractive.util.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit

interface RetrofitInterface {

    @GET("nzin01312019187360.json")
    suspend fun getINDNZMatchDetails(): Response<INDNZMatchDetailsResponse>

    @GET("sapk01222019186652.json")
    suspend fun getSAPAKMatchDetails(): Response<SAPAKMatchDetailsResponse>

    companion object {
        var retrofitInterface: RetrofitInterface? = null
        fun getInstance(): RetrofitInterface {

            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build()
            if (retrofitInterface == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build()
                retrofitInterface = retrofit.create(RetrofitInterface::class.java)
            }
            return retrofitInterface!!
        }

    }
}