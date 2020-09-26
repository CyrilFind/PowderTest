package com.powder.powdertest

import android.content.Context
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

object FakeDependencyInjection {

    lateinit var context: Context
    fun init(context: Context) {
        this.context = context
    }

    private val kotlinxJson = Json {
        coerceInputValues = true
        ignoreUnknownKeys = true
        isLenient = true
    }

    private val baseUrl = "https://firebasestorage.googleapis.com/v0/b/powder-c9282.appspot.com/o/test/"

    private val converterFactory = kotlinxJson.asConverterFactory("application/json".toMediaType())

    private val client = OkHttpClient.Builder()
        .addNetworkInterceptor(
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.HEADERS
            }
        )
        .build()

    private val retrofit = Retrofit.Builder()
        .client(client)
        .baseUrl(baseUrl)
        .addConverterFactory(converterFactory)
        .build()

    private val videosApi: VideosApi by lazy { retrofit.create(VideosApi::class.java) }

    // Use this one to get from network: NetworkVideoDataSource(videosApi)
    private val videoDatasource: VideosDataSource by lazy { LocalVideoDataSource(kotlinxJson, context.resources) }

    private val videosRepository: VideosRepository by lazy { DefaultVideosRepository(videoDatasource) }

    private val getVideosInteractor by lazy { getVideosInteractor(videosRepository) }

    val mainViewModel by lazy { MainViewModel(getVideosInteractor) }

}