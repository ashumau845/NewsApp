package info.ort.recyclerkotlin.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import info.ort.recyclerkotlin.Model.Article
import info.ort.recyclerkotlin.R
import kotlinx.android.synthetic.main.item_layout.view.*

class NewsAdapter(val context: Context,val article: List<Article>,private val clickListener: (Article) -> Unit) :
    RecyclerView.Adapter<ArticleViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view=LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false)
        return ArticleViewHolder(view)
    }

    override fun getItemCount(): Int {
        return article.size
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        /*val article=article.get(position)
        holder.itemView.newsTitle.text=article.title
        holder.itemView.newsDesc.text=article.description
        Glide.with(context).load(article.urlToImage).into(holder.itemView.newsImage)
        holder.itemView.newsItem.setOnClickListener{
            Toast.makeText(context,article.title,Toast.LENGTH_SHORT).show()
        }*/
        val article=article.get(position)
        holder.bind(article,clickListener)
    }


}

class ArticleViewHolder(val itemview: View) : RecyclerView.ViewHolder(itemview) {
    fun bind(article:Article,clickListener: (Article) -> Unit){
        itemView.newsTitle.text=article.title
        itemview.newsDesc.text=article.description
        Glide.with(itemView.context).load(article.urlToImage).into(itemview.newsImage)
        itemview.newsItem.setOnClickListener {
            //Toast.makeText(itemview.context,article.title,Toast.LENGTH_SHORT).show()
            clickListener(article)
        }
    }
}