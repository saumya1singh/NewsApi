package com.example.newsapi

import android.content.Context
import android.support.v7.view.menu.ActionMenuItemView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.news_row.view.*

class  NewsAdapter(private val newnews:ArrayList<Myclass>,val c:Context) : RecyclerView.Adapter<NewsAdapter.NewsHolder>()
{


    override fun onBindViewHolder(p0: NewsHolder, p1: Int) {

        p0.title.setText(newnews.get(p1).title)
        p0.url.setText(newnews.get(p1).url)
        p0.urlToImage.setText(newnews.get(p1).urlToImage)
    }

    override fun getItemCount(): Int {
                return newnews.size
    }
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): NewsHolder
    {
            return  NewsHolder(LayoutInflater.from(c).inflate(R.layout.news_row,p0,false))

    }

    class NewsHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val  title:TextView=itemView.title_text
         val url:TextView=itemView.title_url
             val urlToImage:TextView=itemView.urlimg
    }
}