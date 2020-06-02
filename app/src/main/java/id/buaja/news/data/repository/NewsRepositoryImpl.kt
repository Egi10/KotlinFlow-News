package id.buaja.news.data.repository

import id.buaja.news.BuildConfig
import id.buaja.news.data.entity.NewsResponse
import id.buaja.news.data.routes.NewsServices
import retrofit2.Response

/**
 * Created By Julsapargi Nursam 6/2/20
 */
 
class NewsRepositoryImpl(private val newsServices: NewsServices) : NewsRepository {
    override suspend fun getNewsEverything(domains: String?): Response<NewsResponse> {
        return newsServices.getNewsEverything(BuildConfig.API_KEY, domains)
    }

}