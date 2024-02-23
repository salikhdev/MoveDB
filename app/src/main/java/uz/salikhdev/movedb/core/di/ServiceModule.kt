package uz.salikhdev.movedb.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import uz.salikhdev.movedb.core.network.ActingService
import uz.salikhdev.movedb.core.network.ActorService
import uz.salikhdev.movedb.core.network.AuthService
import uz.salikhdev.movedb.core.network.DetailService
import uz.salikhdev.movedb.core.network.HomeService
import uz.salikhdev.movedb.core.network.ProfileService
import uz.salikhdev.movedb.core.network.SeeMoreService
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

    @[Provides Singleton]
    fun provideDetailService(retrofit: Retrofit): DetailService {
        return retrofit.create(DetailService::class.java)
    }

    @[Provides Singleton]
    fun provideActorService(retrofit: Retrofit): ActorService {
        return retrofit.create(ActorService::class.java)
    }

    @[Provides Singleton]
    fun provideActingService(retrofit: Retrofit): ActingService {
        return retrofit.create(ActingService::class.java)
    }

    @[Provides Singleton]
    fun provideSeeMoreService(retrofit: Retrofit): SeeMoreService {
        return retrofit.create(SeeMoreService::class.java)
    }


}