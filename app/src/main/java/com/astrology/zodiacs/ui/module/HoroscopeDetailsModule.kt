package com.astrology.zodiacs.ui.module


import com.astrology.zodiacs.data.repository.MainRepository
import com.astrology.zodiacs.ui.viewmodel.HoroscopeDetailsViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@InstallIn(ActivityComponent::class)
@Module
abstract class HoroscopeDetailsModule {

    companion object{
        @Provides
        @JvmStatic
        fun provideMainViewModel(mainRepository: MainRepository): HoroscopeDetailsViewModel{
            return HoroscopeDetailsViewModel(mainRepository)
        }
    }

}