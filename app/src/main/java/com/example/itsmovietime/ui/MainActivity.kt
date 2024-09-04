package com.example.itsmovietime.ui


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.itsmovietime.MovieScreen
import com.example.itsmovietime.ViewModel.MovieViewModel
import com.example.itsmovietime.theme.ItsMovieTimeTheme

//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            ItsMovieTimeTheme {
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colors.background
//                ) {
//                    MovieApp()
//                }
//            }
//        }
//    }
//}
//@Composable
//fun MovieApp() {
//    val viewModel: MovieViewModel = viewModel()
//    val movies by viewModel.observeMovieLiveData().collectAsState(initial = emptyList())
//
//    LaunchedEffect(Unit) {
//        viewModel.getMyMovieData()
//    }
//
//    MovieScreen(movies = movies)
//}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ItsMovieTimeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MovieApp()
                }
            }
        }
    }
}

@Composable
fun MovieApp() {
    val viewModel: MovieViewModel = viewModel()
    val movies by viewModel.observeMovieLiveData().collectAsState(initial = emptyList())

    LaunchedEffect(Unit) {
        viewModel.getMyMovieData()
    }

    MovieScreen(movies = movies)
}
