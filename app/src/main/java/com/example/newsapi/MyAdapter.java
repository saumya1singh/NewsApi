package com.example.newsapi;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder>
{   private Context context;
    private ArrayList< Myclass>news=new ArrayList<>();

    public MyAdapter(Context context, ArrayList<Myclass> news) {
        this.context = context;
        this.news = news;
    }

    @NonNull
    @Override
    public MyAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) { View v= LayoutInflater.from(context).inflate(R.layout.news_row,viewGroup,false);
        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyHolder myHolder, int i) {
    myHolder.title.setText(news.get(i).getTitle());
     myHolder.url.setText(news.get(i).getUrl());
     myHolder.urltoimage.setText(news.get(i).getUrlToImage());
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView title,url,urltoimage;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title_text);
            url=itemView.findViewById(R.id.title_url);
            urltoimage=itemView.findViewById(R.id.urlimg);
        }
    }
}
