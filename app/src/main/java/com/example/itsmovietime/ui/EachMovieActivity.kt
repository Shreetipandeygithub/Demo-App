package com.example.itsmovietime.ui

import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.itsmovietime.R
import com.example.itsmovietime.databinding.ActivityMainBinding

class EachMovieActivity : AppCompatActivity() {
    private lateinit var binding : EachMovieActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_each_movie)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        
//        // Retrieve data from Intent
//        val title = intent.getStringExtra("title")
//        val overview = intent.getStringExtra("overview")
//        val posterPath = intent.getStringExtra("poster_path")
//        val releaseDate = intent.getStringExtra("release_date")
//        val voteAverage = intent.getStringExtra("vote_average")
//        val popularity = intent.getStringExtra("popularity")
//
//
//        // Find views and set the data
//        findViewById<TextView>(R.id.titleMovie).text = title
//        findViewById<TextView>(R.id.overview).text = overview
//        findViewById<TextView>(R.id.releaseTextView).text = releaseDate
//        findViewById<TextView>(R.id.ratingTextView).text = voteAverage
//        findViewById<TextView>(R.id.popularityTextView).text = popularity
//
//        val posterUrl = "https://image.tmdb.org/t/p/w500$posterPath"
//        Glide.with(this).load(posterUrl).into(findViewById(R.id.imgView))
//
//        findViewById<ImageButton>(R.id.imgArrow).setOnClickListener {
//            onBackPressed()
//        }
    }
}