package com.testapp.domain.repository

import androidx.lifecycle.LiveData
import com.testapp.data.local.TestAppDatabase
import com.testapp.data.remote.ArticleFavoritesDataSource
import com.testapp.domain.db.Article
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ArticleFavoritesRepository @Inject constructor(
    private val mAppDatabase: TestAppDatabase
) : ArticleFavoritesDataSource {
    override fun getAllFavorites(): LiveData<List<Article>> = mAppDatabase.articleDao().getAllFavorites()
}