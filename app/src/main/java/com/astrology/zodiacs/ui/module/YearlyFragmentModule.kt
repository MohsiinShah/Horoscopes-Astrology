package com.astrology.zodiacs.ui.module

import com.astrology.zodiacs.data.repository.MainRepository
import com.astrology.zodiacs.ui.viewmodel.YearlyViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@InstallIn(FragmentComponent::class)
@Module
abstract class YearlyFragmentModule {

    companion object{
        @Provides
        @JvmStatic
        fun provideMainViewModel(mainRepository: MainRepository): YearlyViewModel {
            return YearlyViewModel(mainRepository)
        }
    }
}