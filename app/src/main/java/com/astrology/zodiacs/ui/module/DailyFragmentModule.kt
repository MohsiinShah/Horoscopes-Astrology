package com.astrology.zodiacs.ui.module


import com.astrology.zodiacs.data.repository.MainRepository
import com.astrology.zodiacs.ui.viewmodel.DailyViewModel
import dagger.Module
import dagger.Provides

@Module
abstract class DailyFragmentModule {

    @Module
    companion object{
        @Provides
        @JvmStatic
        fun provideMainViewModel(mainRepository: MainRepository): DailyViewModel{
            return DailyViewModel(mainRepository)
        }
    }
}