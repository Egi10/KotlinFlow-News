package id.buaja.news

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.buaja.news.ui.news.NewsFragment
import kotlinx.coroutines.ExperimentalCoroutinesApi

class MainActivity : AppCompatActivity() {

    @ExperimentalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val fragment = NewsFragment()
        fragmentTransaction.add(R.id.container, fragment)
        fragmentTransaction.commit()
    }
}
