package ru.mgts.di

import dagger.Component
import ru.antonov.cats.main.MainActivity
import ru.antonov.cats.app.CatsApplication
import ru.antonov.cats.di.NavigationModule
import ru.antonov.cats.main.MainPresenter
import ru.antonov.cats.navigator.Navigator
import ru.antonov.cats.screens.cats.CatsPresenter

import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class, NavigationModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)
    fun inject(application: CatsApplication)
    fun inject(navigator: Navigator)

    fun inject(presenter: CatsPresenter)
    fun inject(presenter: MainPresenter)
}