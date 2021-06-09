package com.astrology.zodiacs.ui.module

import com.astrology.zodiacs.data.repository.MainRepository
import com.astrology.zodiacs.ui.viewmodel.DailyViewModel
import com.astrology.zodiacs.ui.viewmodel.MonthlyViewModel
import dagger.Module
import dagger.Provides

@Module
abstract class MonthlyFragmentModule {

    @Module
    companion object{
        @Provides
        @JvmStatic
        fun provideMainViewModel(mainRepository: MainRepository): MonthlyViewModel {
            return MonthlyViewModel(
                mainRepository)
        }
    }
}