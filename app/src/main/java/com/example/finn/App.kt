package com.example.finn

import android.app.Application
import android.content.Context
import com.example.finn.di.AppComponent
import com.example.finn.di.ContextModule
import com.example.finn.di.DaggerAppComponent
import timber.log.Timber

class App : Application() {

    lateinit var daggerAppComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        daggerAppComponent = DaggerAppComponent
            .builder()
            .contextModule(ContextModule(this))
            .build()
    }

    companion object{
        fun getApp(context: Context): App = context.applicationContext as App
    }

}