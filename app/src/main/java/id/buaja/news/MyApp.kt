package id.buaja.news

import android.app.Application
import id.buaja.news.di.Modules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 * Created By Julsapargi Nursam 6/2/20
 */

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()

        //Start Koin
        startKoin {
            androidLogger()
            androidContext(this@MyApp)
            Modules()
        }
    }
}