package com.example.newapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.newapp.databinding.ActivityDetailedScreenBinding
import com.example.newapp.databinding.ActivityMainBinding

class DetailedScreen : AppCompatActivity() {
    private lateinit var binding : ActivityDetailedScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityDetailedScreenBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_detailed_screen)

        val title = intent.getStringExtra("title")
        val description = intent.getStringExtra("description")
        val imageUrl = intent.getStringExtra("urlToImage")


        binding.title.text = title
        binding.desc.text = description

        Glide.with(this)
            .load(imageUrl)
            .into(binding.tumbIamge)


        binding.readmore.setOnClickListener {
            imageUrl?.let {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(it)))
            }
        }

    }
}