package ru.mgts.di

import android.content.Context
import dagger.Module
import dagger.Provides
import io.reactivex.annotations.NonNull
import ru.antonov.cats.cache.Cache
import ru.antonov.cats.network.CatsApi
import javax.inject.Singleton

@Module
class NetworkModule {
    @Singleton
    @NonNull
    @Provides
    fun apiClient(context: Context) = CatsApi(context)

    @Singleton
    @NonNull
    @Provides
    fun catsApi(apiClient: CatsApi) = apiClient.getCatsApi()

    @Singleton
    @NonNull
    @Provides
    fun cache(context: Context) : Cache = Cache(context)
}