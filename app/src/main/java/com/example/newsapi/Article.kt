package com.example.newsapi



data class Articles(val totalResults: Int ,
                    val articles: List<Myclass>,
                    val status: String )

data class  Myclass(val publishedAt: String ,
                        val author: String ,
                        val urlToImage: String ,
                        val description: String ,
                        val source: Source,
                        val title: String ,
                        val url: String ,
                        val content: String)


data class Source(val name: String ,
                     val id: Int)


