package com.astrology.zodiacs

import android.app.Activity
import android.app.Application
import android.app.Fragment
import android.content.Context
import androidx.multidex.MultiDex
import com.astrology.zodiacs.di.component.AppComponent
import com.astrology.zodiacs.di.component.DaggerAppComponent


import dagger.android.*

import javax.inject.Inject

class MyApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchAndroidException: DispatchingAndroidInjector<Activity>


    private lateinit var appComponent: AppComponent

    companion object {
        lateinit var application: MyApplication
            private set

        val context: Context
            get() = application.applicationContext
    }

    override fun onCreate() {
        super.onCreate()
        application = this
//        FirebaseApp.initializeApp(this)
//        basicClient = BasicChatClient(applicationContext)
        appComponent = DaggerAppComponent.builder().application(this).build()
        appComponent.inject(this)
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = dispatchAndroidException
}