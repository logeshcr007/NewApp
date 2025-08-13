package com.example.newapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.example.Articles
import com.example.newapp.DetailedScreen
import com.example.newapp.databinding.NewsiteamLayoutBinding

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    private var newsList = ArrayList<Articles>()
    fun setNewsList(movieList: List<Articles>) {
        this.newsList = movieList as ArrayList<Articles>
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: NewsiteamLayoutBinding) : RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            NewsiteamLayoutBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article = newsList[position]
        Glide.with(holder.itemView)
            .load( newsList[position].urlToImage)
            .into(holder.binding.tumbIamge)
        holder.binding.title.text = newsList[position].title
        holder.binding.desc.text = newsList[position].description

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, DetailedScreen::class.java)
            intent.putExtra("title",article.title )
            intent.putExtra("description", article.description)
            intent.putExtra("imageUrl", article.urlToImage)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return newsList.size
    }
}