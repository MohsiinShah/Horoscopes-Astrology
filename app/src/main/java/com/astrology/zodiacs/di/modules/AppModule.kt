package com.astrology.zodiacs.di.modules

import android.app.Application
import android.content.Context
import com.astrology.zodiacs.MyApplication
import com.astrology.zodiacs.data.api.ApiHelper
import com.astrology.zodiacs.data.api.ApiService
import com.astrology.zodiacs.data.repository.MainRepository


import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    internal fun provideApplication(app: MyApplication): Application {
        return app
    }

    @Provides
    @Singleton
    fun providesContext(): Context {
        return MyApplication.context
    }

    @Provides
    @Singleton
    fun providesRepository(apiHelper: ApiHelper): MainRepository {
        return MainRepository(apiHelper)
    }

    @Provides
    @Singleton
    fun providesApiHelper(apiService: ApiService): ApiHelper {
        return ApiHelper(apiService)
    }
}