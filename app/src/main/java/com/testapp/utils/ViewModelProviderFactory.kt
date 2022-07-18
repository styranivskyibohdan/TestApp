@file:Suppress("UNCHECKED_CAST")

package com.testapp.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.testapp.data.remote.ArticleDataSource
import com.testapp.data.remote.ArticleDetailsDataSource
import com.testapp.data.remote.ArticleFavoritesDataSource
import com.testapp.ui.main.MainViewModel
import com.testapp.ui.main.article.ArticleViewModel
import com.testapp.ui.main.article_detail.ArticleDetailsViewModel
import com.testapp.ui.main.favorite.FavoritesViewModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ViewModelProviderFactory @Inject constructor(
    private val articleDataSource: ArticleDataSource,
    private val articleDetailsDataSource: ArticleDetailsDataSource,
    private val articleFavoritesDataSource: ArticleFavoritesDataSource
) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> {
                MainViewModel() as T
            }
            modelClass.isAssignableFrom(ArticleViewModel::class.java) -> {
                ArticleViewModel(articleDataSource) as T
            }
            modelClass.isAssignableFrom(ArticleDetailsViewModel::class.java) -> {
                ArticleDetailsViewModel(articleDetailsDataSource) as T
            }
            modelClass.isAssignableFrom(FavoritesViewModel::class.java) -> {
                FavoritesViewModel(articleFavoritesDataSource) as T
            }
            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }
}