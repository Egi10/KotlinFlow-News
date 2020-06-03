package id.buaja.news.untils

import retrofit2.Response

/**
 * Created By Julsapargi Nursam 6/3/20
 */

fun <T : Any> fetchError(response: Response<T>): ResultState.Message {
    return when (response.code()) {
        404 -> {
            ResultState.Message("Not Found")
        }

        401 -> {
            ResultState.Message("Auth")
        }

        in 500..599 -> {
            ResultState.Message("Server Kami Sedang Bermasalah")
        }

        else -> {
            ResultState.Message(response.message())
        }
    }
}