package id.buaja.news.untils

sealed class ResultState<out T: Any> {
    data class Message(val message: String): ResultState<String>()
    data class Success<out T: Any>(val data: T?): ResultState<T>()
}