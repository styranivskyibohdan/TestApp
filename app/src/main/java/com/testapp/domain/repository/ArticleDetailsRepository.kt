package com.testapp.domain.repository

import com.testapp.data.local.TestAppDatabase
import com.testapp.data.remote.ApiService
import com.testapp.data.remote.ArticleDetailsDataSource
import com.testapp.di.ApiInfo
import com.testapp.domain.Result
import com.testapp.domain.db.Article
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ArticleDetailsRepository @Inject constructor(
    private val mAppDatabase: TestAppDatabase,
    private val apiService: ApiService,
    @param:ApiInfo private val apiKey: String
) : ArticleDetailsDataSource {
    override suspend fun insert(article: Article) = mAppDatabase.articleDao().insert(article)
    override suspend fun delete(article: Article) = mAppDatabase.articleDao().delete(article)
    override suspend fun getFavoriteById(id: Long): Result<Article> {
        return try {
            Result.Success(mAppDatabase.articleDao().getFavoriteById(id))
        } catch (e: Exception) {
            Result.Error(e.localizedMessage)
        }
    }
}