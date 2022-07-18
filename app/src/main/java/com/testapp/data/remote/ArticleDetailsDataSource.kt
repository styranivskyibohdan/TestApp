package com.testapp.data.remote

import com.testapp.domain.Result
import com.testapp.domain.db.Article

interface ArticleDetailsDataSource {
    suspend fun insert(article: Article)
    suspend fun delete(article: Article)
    suspend fun getFavoriteById(id: Long): Result<Article>
}