package com.luannt.lap10515.demokotlin.application.component.modules

import android.app.Application
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.luannt.lap10515.demokotlin.BuildConfig
import com.luannt.lap10515.demokotlin.application.MainApplication
import com.luannt.lap10515.demokotlin.application.component.scopes.ControllerScope
import com.luannt.lap10515.demokotlin.utils.ConnectionUtil
import com.luannt.lap10515.demokotlin.utils.Constant
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Named

/**
 * Created by lap10515 on 02/08/2017.
 */
@Module
class RetrofitModule() {

    var application: Application? = null

    @Inject constructor(_application: MainApplication) : this() {
        application = _application
    }
    @Provides
    fun provideGsonModule(): Gson = GsonBuilder().create()

    @Provides
    fun provideOkHttpCacheModule(): Cache {
        val cache_size= 10 * 1024 * 1024L // 10 Mb
        val cacheFile = File(application?.applicationContext?.cacheDir, "responses")
        var cache = Cache(cacheFile, cache_size)
        return cache
    }

    @Provides
    fun provideHttpLoggingIntercreptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    @Named("offline")
    fun provideCacheOfflineInterceptor(): Interceptor {
        var interceptor = Interceptor { chain ->
            val request = chain.request()
            if (!ConnectionUtil.isAvailableConection(application!!)) {
                request.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-control", "public, only-if-cache")
                        .build()
            }
            chain.proceed(request)
        }
        return interceptor
    }

    @Provides
    @Named("online")
    fun provideCacheOnlineInterceptor(): Interceptor {
        var interceptor = Interceptor { chain ->
            val request = chain.request()
            val originalResponse: Response = chain.proceed(request)
            var cacheControl: String? = originalResponse.header("Cache-control")

            if (cacheControl!!.contains("no-store") || cacheControl!!.contains("no-cache") ||
                    cacheControl!!.contains("must-revalidate") || cacheControl!!.contains("max-age=0")) {
                originalResponse.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public, max-age=" + 5000)
                        .build();
            } else originalResponse
        }
        return interceptor
    }

    @Provides
    fun proviceOkHttpClientBuilder(loggingInterceptor: HttpLoggingInterceptor,
                                   cache: Cache,
                                   @Named("offline") offline: Interceptor,
                                   @Named("online") online: Interceptor): OkHttpClient.Builder {
        return OkHttpClient.Builder()
                .connectTimeout(Constant.CONNECTION_TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(Constant.CONNECTION_TIME_OUT, TimeUnit.SECONDS)
                //.addInterceptor(offline)
                .addInterceptor(loggingInterceptor)
                .addNetworkInterceptor(online)
                .cache(cache)
    }

    @Provides
    fun provideRx2JavaAdapter(): RxJava2CallAdapterFactory = RxJava2CallAdapterFactory.create()

    @Provides
    @ControllerScope
    fun provideRetrofitModule(rxJava2CallAdapterFactory: RxJava2CallAdapterFactory,
                              okHttpClient: OkHttpClient.Builder,
                              gson: Gson): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BuildConfig.HOST)
                .addCallAdapterFactory(rxJava2CallAdapterFactory)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient.build())
                .build()
    }
}