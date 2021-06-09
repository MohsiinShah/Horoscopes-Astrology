package com.astrology.zodiacs.ui.module


import com.astrology.zodiacs.data.repository.MainRepository
import com.astrology.zodiacs.ui.activities.HoroscopeDetails
import com.astrology.zodiacs.ui.fragments.DailyFragment
import com.astrology.zodiacs.ui.fragments.MonthlyFragment
import com.astrology.zodiacs.ui.fragments.WeeklyFragment
import com.astrology.zodiacs.ui.fragments.YearlyFragment
import com.astrology.zodiacs.ui.viewmodel.DailyViewModel
import com.astrology.zodiacs.ui.viewmodel.HoroscopeDetailsViewModel
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
abstract class HoroscopeDetailsModule {

    @Module
    companion object{
        @Provides
        @JvmStatic
        fun provideMainViewModel(mainRepository: MainRepository): HoroscopeDetailsViewModel{
            return HoroscopeDetailsViewModel(mainRepository)
        }
    }

    @ContributesAndroidInjector(modules = [DailyFragmentModule::class])
    abstract fun bindsDailyFragment(): DailyFragment

    @ContributesAndroidInjector(modules = [WeeklyFragmentModule::class])
    abstract fun bindsWeeklyFragment(): WeeklyFragment

    @ContributesAndroidInjector(modules = [MonthlyFragmentModule::class])
    abstract fun bindsMonthlyFragment(): MonthlyFragment

    @ContributesAndroidInjector(modules = [YearlyFragmentModule::class])
    abstract fun bindsYearlyFragment(): YearlyFragment

}