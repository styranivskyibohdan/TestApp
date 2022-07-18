package com.testapp.di.modules

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.testapp.BuildConfig
import com.testapp.data.local.TestAppDatabase
import com.testapp.data.remote.ApiService
import com.testapp.data.remote.ArticleDataSource
import com.testapp.data.remote.ArticleDetailsDataSource
import com.testapp.data.remote.ArticleFavoritesDataSource
import com.testapp.di.ApiInfo
import com.testapp.domain.repository.ArticleDetailsRepository
import com.testapp.domain.repository.ArticleFavoritesRepository
import com.testapp.domain.repository.ArticleRepository
import com.testapp.utils.AppConstants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class GeneralModule {
    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @ApiInfo
    fun provideApiKey(): String {
        return BuildConfig.API_KEY
    }

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create<ApiService>(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideAppDatabase(context: Context): TestAppDatabase {
        return Room.databaseBuilder(context, TestAppDatabase::class.java, AppConstants.DB_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideArticleDataSource(ArticleRepository: ArticleRepository): ArticleDataSource {
        return ArticleRepository
    }

    @Provides
    @Singleton
    fun provideArticleDetailsDataSource(ArticleDetailsRepository: ArticleDetailsRepository): ArticleDetailsDataSource {
        return ArticleDetailsRepository
    }

    @Provides
    @Singleton
    fun provideArticleFavoritesDataSource(ArticleFavoritesRepository: ArticleFavoritesRepository): ArticleFavoritesDataSource {
        return ArticleFavoritesRepository
    }
}