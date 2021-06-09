package com.astrology.zodiacs.ui.module

import com.astrology.zodiacs.data.repository.MainRepository
import com.astrology.zodiacs.ui.viewmodel.DailyViewModel
import com.astrology.zodiacs.ui.viewmodel.WeeklyViewModel
import dagger.Module
import dagger.Provides

@Module
abstract class WeeklyFragmentModule {

    @Module
    companion object{
        @Provides
        @JvmStatic
        fun provideMainViewModel(mainRepository: MainRepository): WeeklyViewModel {
            return WeeklyViewModel(mainRepository)
        }
    }
}