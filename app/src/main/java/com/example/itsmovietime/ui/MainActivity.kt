package com.example.itsmovietime.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.itsmovietime.ui.Adapter.MovieAdapter
import com.example.itsmovietime.R
import com.example.itsmovietime.ViewModel.MovieViewModel
import com.example.itsmovietime.databinding.ActivityMainBinding
import com.example.itsmovietime.Model.Data.Result


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel: MovieViewModel
    private lateinit var movieAdapter : MovieAdapter

//    private val apiKey="38a73d59546aa378980a88b645f487fc"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prepareRecyclerView()
        searchView()

        viewModel = ViewModelProvider(this)[MovieViewModel::class.java]
        viewModel.getMyMovieData()
        viewModel.observeMovieLiveData().observe(this, Observer { resultList ->
            movieAdapter.setMovieList(resultList)
            setUpImageSlider(resultList)
        })

    }

    private fun searchView() {
        binding.searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterMovies(newText)
                return true
            }

        })
    }

    private fun filterMovies(query: String?) {
        val originalList = viewModel.observeMovieLiveData().value
        val filteredList = originalList?.filter { movie ->
            movie.title.contains(query ?: "", ignoreCase = true)
        }

        filteredList?.let {
            movieAdapter.setMovieList(it)
        }
    }

    private fun setUpImageSlider(movieList: List<Result>) {
        // Fetch only the first 6 movies
        val topMovies = movieList.take(6)

        // Create a list of SlideModel objects from the top 6 movies
        val imageList = ArrayList<SlideModel>()
        for (movie in topMovies) {
            val posterUrl = "https://image.tmdb.org/t/p/w500" + movie.poster_path
            imageList.add(SlideModel(posterUrl, movie.title, ScaleTypes.FIT))
        }

        // Set the images to the image slider
        binding.imageSlider.setImageList(imageList)
    }


    private fun prepareRecyclerView() {
        movieAdapter = MovieAdapter(this@MainActivity)
        binding.popularRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = movieAdapter
        }
    }

}

