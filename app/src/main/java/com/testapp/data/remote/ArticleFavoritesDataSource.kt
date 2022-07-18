package com.testapp.data.remote

import androidx.lifecycle.LiveData
import com.testapp.domain.db.Article

interface ArticleFavoritesDataSource {
    fun getAllFavorites(): LiveData<List<Article>>
}