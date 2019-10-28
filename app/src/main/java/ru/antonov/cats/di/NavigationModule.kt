package ru.antonov.cats.di

import android.content.Context
import dagger.Module
import dagger.Provides
import io.reactivex.annotations.NonNull
import ru.antonov.cats.cache.Cache
import ru.antonov.cats.network.CatsApi
import ru.mgts.navigation.Router
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder

import javax.inject.Singleton

@Module
class NavigationModule {
    private val mRouter = Router()
    private val mCicerone = Cicerone.create(mRouter)

    @NonNull
    @Provides
    @Singleton
    fun navigatorHolder() = mCicerone.navigatorHolder!!

    @Singleton
    @NonNull
    @Provides
    fun router() = mRouter
}