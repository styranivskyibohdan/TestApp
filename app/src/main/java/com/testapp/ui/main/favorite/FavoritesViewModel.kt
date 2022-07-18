package com.testapp.ui.main.favorite

import androidx.lifecycle.LiveData
import com.testapp.data.remote.ArticleFavoritesDataSource
import com.testapp.domain.db.Article
import com.testapp.ui.base.BaseViewModel

class FavoritesViewModel(
    articleFavoritesDataSource: ArticleFavoritesDataSource
) : BaseViewModel() {
    val articlesLiveData: LiveData<List<Article>> = articleFavoritesDataSource.getAllFavorites()
}