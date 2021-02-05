package daniellopes.io.newsappstarter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import daniellopes.io.newsappstarter.R
import daniellopes.io.newsappstarter.model.Article
import kotlinx.android.synthetic.main.item_news.view.*

class MainAdapter:RecyclerView.Adapter<MainAdapter.ArticleViewHolder>() {
    class ArticleViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)

    private val differCallBack = object : DiffUtil.ItemCallback<Article>(){
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }

    }
    val differ = AsyncListDiffer(this,differCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder = ArticleViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.item_news,parent,false)
    )



    override fun getItemCount(): Int = differ.currentList.size

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = differ.currentList[position]
        holder.itemView.apply {
            Glide.with(this).load(article.urlToImage).into(imageView)
            titleView.text = article.source?.name
            desc.text = article.description

            setOnClickListener {
                onItemClickListener?.let { click ->
                    click(article)
                }
            }
        }
    }
    private var onItemClickListener: ((Article) -> Unit)?=null

    fun setOnclickListener(listner:(Article) -> Unit){
        onItemClickListener = listner
    }
}