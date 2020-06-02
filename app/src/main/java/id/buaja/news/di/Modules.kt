package id.buaja.news.di

import org.koin.core.context.loadKoinModules

/**
 * Created By Julsapargi Nursam 6/2/20
 */

class Modules {
    private val modules = listOf(
        networkModule,
        repositoryModule,
        useCaseModule,
        viewModelModule
    )

    init {
        loadKoinModules(modules)
    }
}