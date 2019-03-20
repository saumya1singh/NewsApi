package com.example.newsapi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.ImageView
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {
                   private  val news="https://newsapi.org/v2/everything?q=bitcoin&from=2019-02-20&sortBy=publishedAt&apiKey=21bb241788a24064917fffc087581b4c"
                    private val gson=Gson()
                    val newslist= arrayListOf<Myclass>()

                        override fun onCreate(savedInstanceState: Bundle?) {
                        super.onCreate(savedInstanceState)
                        setContentView(R.layout.activity_main)

                            val client=OkHttpClient()
                            val request= Request.Builder()
                                .url(news)
                                    .build()

                client.newCall(request).enqueue(object : Callback{
                override fun onResponse( call: Call, response: Response)
                {
                                  val  responseBody:ResponseBody?=response.body()
                                        val result=responseBody?.string()
                                            val response=gson.fromJson(result,Myclass::class.java)
                                                newslist.add(response)
                                                      runOnUiThread {
                                                          val newsAdapter= MyAdapter(this@MainActivity,newslist)
                                                          rvnews.layoutManager= LinearLayoutManager(baseContext)
                                                          rvnews.adapter=newsAdapter
                                                          rvnews.adapter?.notifyDataSetChanged()}
                }
                override fun onFailure(call: Call, e: IOException) {
                         e.printStackTrace()
                }})

            }
        }
