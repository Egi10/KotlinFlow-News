package id.buaja.news.untils

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created By Julsapargi Nursam 6/3/20
 */

fun String.dateFormatUtc() : String {
    val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
    inputFormat.timeZone = TimeZone.getTimeZone("UTC")
    val myDate = inputFormat.parse(this)
    val locale = Locale("id")
    val outputFormat = SimpleDateFormat("EEEE, dd MMMM yyyy HH:mm", locale)
    var dateFormat = ""
    myDate?.let {
        val myDateAsString = outputFormat.format(it)
        dateFormat = myDateAsString
    }

    return dateFormat
}