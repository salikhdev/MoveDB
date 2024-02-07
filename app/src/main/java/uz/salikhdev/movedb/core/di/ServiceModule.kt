package uz.salikhdev.movedb.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import uz.salikhdev.movedb.core.network.AuthService
import uz.salikhdev.movedb.core.network.HomeService
import uz.salikhdev.movedb.core.network.ProfileService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @[Provides Singleton]
    fun provideAuthService(retrofit: Retrofit): AuthService {
        return retrofit.create(AuthService::class.java)
    }

    @[Provides Singleton]
    fun provideProfileService(retrofit: Retrofit): ProfileService {
        return retrofit.create(ProfileService::class.java)
    }

    @[Provides Singleton]
    fun provideHomeService(retrofit: Retrofit): HomeService {
        return retrofit.create(HomeService::class.java)
    }

}