package com.example.finn.di

import android.content.Context
import com.example.finn.DiscoverApi
import com.example.finn.Schedulers
import com.example.finn.SchedulersImpl
import com.squareup.moshi.Moshi
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import timber.log.Timber


@Module(includes = [NetworkModule::class])
class RetrofitModule() {

    @Provides
    fun provideDiscoverApi(retrofit: Retrofit): DiscoverApi {
        return retrofit.create(DiscoverApi::class.java)
    }

}

@Module(includes = [ContextModule::class, MoshiModule::class, InterceptorModule::class])
class NetworkModule {

    @Provides
    fun provideRetrofit(
        moshiConverter: MoshiConverterFactory,
        okHttpClient: OkHttpClient
    ): Retrofit = Retrofit
        .Builder()
        .baseUrl("https://gist.githubusercontent.com/baldermork/6a1bcc8f429dcdb8f9196e917e5138bd/raw/a542886ef057c91d822004ed15881f0c25221c18/")
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(moshiConverter)
        .client(okHttpClient)
        .build()

    @Provides
    fun provideOkHttpClient(cache: Cache, httpInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .cache(cache)
            .addInterceptor(httpInterceptor)
            .build()
    }

    @Provides
    fun provideCache(context: Context) = Cache(context.cacheDir, 10 * 1024 * 1024) //10mb
}

@Module
class InterceptorModule() {
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor { message -> Timber.d(message) }.apply {
            level = HttpLoggingInterceptor.Level.BASIC
        }
    }
}

@Module
class MoshiModule {

    @Provides
    fun provideMoshi(): Moshi = Moshi.Builder().build()

    @Provides
    fun provideMoshiConverter(moshi: Moshi): MoshiConverterFactory =
        MoshiConverterFactory.create(moshi)
}

@Module
class ContextModule(private val context: Context) {
    @Provides
    fun provideCache(): Context = context
}

@Module
abstract class SchedulerModule {

    @Binds
    abstract fun bindSchedulers(schedulers: SchedulersImpl): Schedulers

}

