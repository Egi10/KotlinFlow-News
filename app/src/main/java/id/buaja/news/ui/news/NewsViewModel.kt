package id.buaja.news.ui.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.buaja.news.data.entity.ArticlesItem
import id.buaja.news.data.entity.NewsResponse
import id.buaja.news.domain.NewsUseCase
import id.buaja.news.untils.ResultState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

/**
 * Created By Julsapargi Nursam 6/2/20
 */

class NewsViewModel(private val useCase: NewsUseCase): ViewModel() {
    private val _news = MutableLiveData<List<ArticlesItem>>()
    val news: LiveData<List<ArticlesItem>> get() = _news

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> get() = _loading

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    private val _message = MutableLiveData<String>()
    val message: LiveData<String> get() = _message

    fun getNewsEverything(domains: String?) {
        viewModelScope.launch(Dispatchers.Main) {
            useCase.getNewsEverything(domains)
                .onStart {
                    _loading.value = true
                }
                .onCompletion {
                    _loading.value = false
                }
                .catch { cause: Throwable ->
                    _error.postValue(cause.message)
                }
                .collect {
                    when(it) {
                        is ResultState.Success -> {
                            val response = it.data as NewsResponse
                            _news.postValue(response.articles)
                        }

                        is ResultState.Message -> {
                            _message.postValue(it.message)
                        }
                    }
                }
        }
    }
}