package id.buaja.news.data.repository

import id.buaja.news.data.entity.NewsResponse
import retrofit2.Response

/**
 * Created By Julsapargi Nursam 6/2/20
 */

interface NewsRepository {
    suspend fun getNewsEverything(domains: String?): Response<NewsResponse>
}