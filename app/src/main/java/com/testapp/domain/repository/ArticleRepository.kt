package com.testapp.domain.repository

import com.testapp.data.remote.ApiService
import com.testapp.data.remote.ArticleDataSource
import com.testapp.di.ApiInfo
import com.testapp.domain.api.ArticlesResponse
import javax.inject.Inject
import javax.inject.Singleton
import com.testapp.domain.Result

@Singleton
class ArticleRepository @Inject constructor(
    private val apiService: ApiService,
    @param:ApiInfo private val apiKey: String
) : ArticleDataSource {
    override suspend fun getArticles(period: Int): Result<ArticlesResponse> {
        return try {
            val articlesResponse = apiService.getArticles(period, apiKey)
            Result.Success(articlesResponse)
        } catch (e: Exception) {
            Result.Error(e.localizedMessage)
        }
    }
}