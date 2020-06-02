package id.buaja.news.ui.news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import coil.transform.RoundedCornersTransformation
import id.buaja.news.R
import id.buaja.news.data.entity.ArticlesItem
import id.buaja.news.untils.dateFormatUtc
import kotlinx.android.synthetic.main.item_list_news.view.*

/**
 * Created By Julsapargi Nursam 6/3/20
 */


class NewsAdapter(
    private val data: List<ArticlesItem>,
    private val listener: (ArticlesItem) -> Unit
) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_news, parent, false)
        )

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(data[position], listener)

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: ArticlesItem, listener: (ArticlesItem) -> Unit) {
            with(itemView) {
                ivImage.load(item.urlToImage) {
                    placeholder(R.drawable.no_image)
                    transformations(RoundedCornersTransformation(20f))
                }
                tvAuthor.text = item.author
                tvPublishedAt.text = item.publishedAt?.dateFormatUtc()
                tvTitle.text = item.title

                setOnClickListener {
                    listener(item)
                }
            }
        }
    }
}