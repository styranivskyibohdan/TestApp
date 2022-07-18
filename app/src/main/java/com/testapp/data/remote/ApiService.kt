package com.testapp.data.remote

import com.testapp.domain.api.ArticlesResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET(ApiEndPoint.ENDPOINT_ARTICLES)
    suspend fun getArticles(
        @Path("period") period: Int,
        @Query("api-key") apiKey: String
    ): ArticlesResponse
}