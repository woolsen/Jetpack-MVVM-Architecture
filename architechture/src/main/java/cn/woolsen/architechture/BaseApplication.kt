package cn.woolsen.architechture

import android.app.Application
import timber.log.Timber

abstract class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}