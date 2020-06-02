package id.buaja.news.ui.news

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager

import id.buaja.news.R
import id.buaja.news.data.entity.ArticlesItem
import kotlinx.android.synthetic.main.fragment_news.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass.
 */
@ExperimentalCoroutinesApi
class NewsFragment : Fragment() {
    private val viewModel by viewModel<NewsViewModel>()
    private var listNews: MutableList<ArticlesItem> = mutableListOf()
    private lateinit var adapter: NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        with(viewModel) {
            loading.observe(this@NewsFragment, Observer {
                swipeRefresh.isRefreshing = it
            })

            news.observe(this@NewsFragment, Observer {
                listNews.clear()
                listNews.addAll(it)
                adapter.notifyDataSetChanged()
            })

            message.observe(this@NewsFragment, Observer {
                Toast.makeText(requireContext(), "Message $it", Toast.LENGTH_SHORT).show()
            })

            error.observe(this@NewsFragment, Observer {
                Toast.makeText(requireContext(), "Error $it", Toast.LENGTH_SHORT).show()
            })
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.title = "detik.com"

        swipeRefresh.post {
            viewModel.getNewsEverything("detik.com")
        }

        swipeRefresh.setOnRefreshListener {
            viewModel.getNewsEverything("detik.com")
        }

        adapter = NewsAdapter(listNews) {

        }
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
        recyclerView.adapter = adapter
    }
}
