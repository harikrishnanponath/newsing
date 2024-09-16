package com.harikrish.newsing.api

import com.harikrish.newsing.model.News
import com.harikrish.newsing.util.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("v2/top-headlines")
    suspend fun getHeadlines(
        @Query("country") countryCode: String,
        @Query("page") pageNumber: Int = 1,
        @Query("apikey") apiKey: String = API_KEY
    ): Response<News>

    @GET("v2/everything")
    suspend fun searchForNews(
        @Query("q") searchQuery: String,
        @Query("page") pageNumber: Int = 1,
        @Query("apikey") apiKey: String = API_KEY
    ): Response<News>

}