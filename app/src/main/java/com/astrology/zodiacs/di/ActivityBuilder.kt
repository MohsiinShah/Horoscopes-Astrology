package com.astrology.zodiacs.di

import com.astrology.zodiacs.ui.activities.HoroscopeDetails
import com.astrology.zodiacs.ui.module.HoroscopeDetailsModule
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule


@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [HoroscopeDetailsModule::class, AndroidSupportInjectionModule::class])
    abstract fun bindsHoroscopeDetails(): HoroscopeDetails

}