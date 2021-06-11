package id.buaja.news.di

import id.buaja.news.data.repository.NewsRepository
import id.buaja.news.data.repository.NewsRepositoryImpl
import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.dsl.single

/**
 * Created By Julsapargi Nursam 6/2/20
 */
 
val repositoryModule = module {
    single<NewsRepositoryImpl>() bind NewsRepository::class
}