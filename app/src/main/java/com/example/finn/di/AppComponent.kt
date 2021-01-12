package com.example.finn.di

import com.example.finn.ui.AdListFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitModule::class, SchedulerModule::class, ViewModelModule::class, DatabaseModule::class])
interface AppComponent {
    fun inject(fragment: AdListFragment)
}