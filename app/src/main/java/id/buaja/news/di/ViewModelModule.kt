package id.buaja.news.di

import id.buaja.news.ui.news.NewsViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created By Julsapargi Nursam 6/2/20
 */

@ExperimentalCoroutinesApi
val viewModelModule = module {
    viewModel {
        NewsViewModel(get())
    }
}