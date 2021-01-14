package com.example.agv_kt.di

import com.example.agv_kt.utils.Constant
import com.example.agv_kt.network.ApiService
import com.example.agv_kt.repository.ApiRepository
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val apiModule = module{
    single { provideOkHttpClient() }
    single { provideApiService(get()) }
    single { provideApiRepository(get()) }
}
//
//fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
//    val httpLoggingInterceptor = HttpLoggingInterceptor()
//    httpLoggingInterceptor.level = when (BuildConfig.DEBUG) {
//        true -> HttpLoggingInterceptor.Level.BODY
//        else -> HttpLoggingInterceptor.Level.NONE
//    }
//    return httpLoggingInterceptor
//}

fun provideOkHttpClient(
//    authInterceptor: AuthInterceptor,
//    httpLoggingInterceptor: HttpLoggingInterceptor
): OkHttpClient {
    return OkHttpClient.Builder()
//        .connectTimeout(30, TimeUnit.SECONDS)
//        .readTimeout(60, TimeUnit.SECONDS)
//        .writeTimeout(60, TimeUnit.SECONDS)
//        .addInterceptor(authInterceptor)
//        .addInterceptor(httpLoggingInterceptor)
        .build()
}


fun provideApiService(okHttpClient: OkHttpClient): ApiService {
    val contentType = "application/json".toMediaType()

    return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
//            .addConverterFactory(Json.asConverterFactory(contentType))
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(ApiService::class.java)

}



fun provideApiRepository(apiService: ApiService): ApiRepository {
    return ApiRepository(apiService)
}
