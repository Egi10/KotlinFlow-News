package id.buaja.news.data.routes

import id.buaja.news.data.entity.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created By Julsapargi Nursam 6/2/20
 */

interface NewsServices {
    @GET("everything")
    suspend fun getNewsEverything(
        @Query("apiKey") apiKey: String?,
        @Query("domains") domains: String?
    ): Response<NewsResponse>
}