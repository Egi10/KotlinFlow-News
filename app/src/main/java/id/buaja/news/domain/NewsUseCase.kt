package id.buaja.news.domain

import id.buaja.news.data.repository.NewsRepository
import id.buaja.news.untils.ResultState
import id.buaja.news.untils.fetchError
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

/**
 * Created By Julsapargi Nursam 6/2/20
 */

@ExperimentalCoroutinesApi
class NewsUseCase(private val repository: NewsRepository) {
    suspend fun getNewsEverything(domains: String?) = flow {
        val response = repository.getNewsEverything(domains)
        if (response.isSuccessful) {
            emit(ResultState.Success(response.body()))
        } else {
            emit(fetchError(response))
        }
    }.flowOn(Dispatchers.IO)
}