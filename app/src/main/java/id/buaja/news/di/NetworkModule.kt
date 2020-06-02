package id.buaja.news.di

import id.buaja.news.data.routes.NewsServices
import id.buaja.news.network.ApiConfig
import org.koin.dsl.module

/**
 * Created By Julsapargi Nursam 6/2/20
 */
 
 val networkModule = module {
    single {
        ApiConfig.createNetworkApi<NewsServices>()
    }
}