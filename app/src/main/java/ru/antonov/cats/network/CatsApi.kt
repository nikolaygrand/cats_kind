package ru.antonov.cats.network

import android.content.Context
import io.reactivex.Observable
import okhttp3.ConnectionSpec
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import ru.antonov.cats.BuildConfig
import java.util.*

class CatsApi constructor(context: Context) {
    private var mClient: ICatsApi

    init {
        val httpClient = OkHttpClient().newBuilder()
            .addInterceptor(object : Interceptor{
                override fun intercept(chain: Interceptor.Chain): Response {
                    val original = chain.request()
                    val request = original.newBuilder()
                        .addHeader("x-api-key", BuildConfig.API_KEY)
                        .addHeader("Content-Type", "application/json; charset=utf-8")
                        .url(original.url)
                        .method(original.method, original.body)
                        .build()
                    return chain.proceed(request)
                }
            })
            .connectionSpecs(listOf(
                ConnectionSpec.MODERN_TLS,
                ConnectionSpec.COMPATIBLE_TLS,
                ConnectionSpec.CLEARTEXT))
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.API_URL)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        mClient = retrofit.create(ICatsApi::class.java)
    }

    fun getCatsApi(): ICatsApi {
        return mClient
    }
}
