package uz.salikhdev.movedb.core.di

import android.content.Context
import androidx.room.Room
import com.chuckerteam.chucker.api.ChuckerInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.salikhdev.movedb.core.room.database.MovieDataBase
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @[Provides Singleton]
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @[Provides Singleton]
    fun provideOkHttpClient(chuckerInterceptor: ChuckerInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .callTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(chuckerInterceptor)
            .build()
    }

    @[Provides Singleton]
    fun provideChukker(@ApplicationContext context: Context): ChuckerInterceptor {
        return ChuckerInterceptor.Builder(context)
            .maxContentLength(250_000)
            .alwaysReadResponseBody(true)
            .build()
    }

    @[Provides Singleton]
    fun getDatabase(context: Context): MovieDataBase {
        var INSTANCE: MovieDataBase? = null
        if (INSTANCE == null) {
            synchronized(this) {
                INSTANCE = buildDatabase(context)
            }
        }
        return INSTANCE!!
    }

    @[Provides Singleton]
    fun buildDatabase(context: Context): MovieDataBase {
        return Room.databaseBuilder(
            context.applicationContext,
            MovieDataBase::class.java,
            "notes_database"
        )
            .build()
    }

}