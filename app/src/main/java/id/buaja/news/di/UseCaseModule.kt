package id.buaja.news.di

import id.buaja.news.domain.NewsUseCase
import org.koin.dsl.module

/**
 * Created By Julsapargi Nursam 6/2/20
 */
 
val useCaseModule = module {
    single { NewsUseCase(get()) }
}