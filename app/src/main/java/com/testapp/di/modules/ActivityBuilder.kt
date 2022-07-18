package com.testapp.di.modules

import com.testapp.ui.main.MainActivity
import com.testapp.ui.main.article.ArticleFragmentProvider
import com.testapp.ui.main.article_detail.ArticleDetailsFragmentProvider
import com.testapp.ui.main.favorite.FavoritesFragmentProvider
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [ArticleFragmentProvider::class, ArticleDetailsFragmentProvider::class, FavoritesFragmentProvider::class])
    abstract fun bindMainActivity(): MainActivity
}