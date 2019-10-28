package ru.antonov.cats.app

import android.app.Application
import ru.antonov.cats.di.NavigationModule
import ru.mgts.di.AppComponent
import ru.mgts.di.AppModule
import ru.mgts.di.DaggerAppComponent
import javax.inject.Inject

class CatsApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
        appComponent.inject(this)
    }

    companion object {
        lateinit var appComponent: AppComponent
    }
}