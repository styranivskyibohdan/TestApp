package com.testapp.data.remote

import com.testapp.domain.api.ArticlesResponse
import com.testapp.domain.Result

interface ArticleDataSource {
    suspend fun getArticles(period: Int): Result<ArticlesResponse>
}