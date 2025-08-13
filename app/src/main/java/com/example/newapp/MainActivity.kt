package com.example.newapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newapp.adapter.NewsAdapter
import com.example.newapp.databinding.ActivityMainBinding
import com.example.newapp.viewmodel.Newsviewmodel

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel: Newsviewmodel
    private lateinit var newsAdapter : NewsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        prepareRecyclerView()

        viewModel = ViewModelProvider(this)[Newsviewmodel::class.java]
        viewModel.getPopularNews()
        viewModel.observeNewsLiveData().observe(this, Observer { newslist ->
            newsAdapter.setNewsList(newslist)
        })

    }

    private fun prepareRecyclerView() {
        newsAdapter = NewsAdapter()
        binding.newaApiRv.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = newsAdapter
        }

    }
}