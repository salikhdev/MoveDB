package uz.salikhdev.movedb.core.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import uz.salikhdev.movedb.core.cache.AppCache
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object StorageModule {

    @Provides
    @Singleton
    fun provideAppCache(@ApplicationContext context: Context): AppCache {
        return AppCache(context)
    }

}