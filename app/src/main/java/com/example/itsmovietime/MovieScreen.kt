package com.example.itsmovietime

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.itsmovietime.Model.Data.Result
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

//@OptIn(ExperimentalPagerApi::class)
//@Composable
//fun MovieScreen(movies: List<Result>) {
//    var searchQuery by remember { mutableStateOf("") }
//    val filteredMovies = movies.filter {
//        it.title.contains(searchQuery, ignoreCase = true)
//    }
//
//    Column(modifier = Modifier.fillMaxSize()) {
//        ImageSlider(movies = movies.take(6))
//        SearchBar(
//            value = searchQuery,
//            onValueChange = { searchQuery = it },
//            modifier = Modifier.padding(16.dp)
//        )
//        MovieList(movies = filteredMovies)
//    }
//}
//
//@OptIn(ExperimentalPagerApi::class)
//@Composable
//fun ImageSlider(movies: List<Result>) {
//    val pagerState = rememberPagerState()
//
//    HorizontalPager(
//        count = movies.size,
//        state = pagerState,
//        modifier = Modifier
//            .height(200.dp)
//            .fillMaxWidth()
//    ) { page ->
//        MovieImage(
//            posterPath = movies[page].poster_path,
//            modifier = Modifier.fillMaxSize()
//        )
//    }
//}
//
//@Composable
//fun SearchBar(
//    value: String,
//    onValueChange: (String) -> Unit,
//    modifier: Modifier = Modifier
//) {
//    TextField(
//        value = value,
//        onValueChange = onValueChange,
//        modifier = modifier.fillMaxWidth(),
//        placeholder = { Text("Search") }
//    )
//}
//
//@Composable
//fun MovieList(movies: List<Result>) {
//    LazyColumn {
//        items(movies) { movie ->
//            MovieItem(movie = movie)
//        }
//    }
//}
//@Composable
//fun MovieItem(movie: Result) {
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(8.dp),
//        elevation = 4.dp
//    ) {
//        Row(modifier = Modifier.padding(8.dp)) {
//            MovieImage(
//                posterPath = movie.poster_path,
//                modifier = Modifier.size(70.dp)
//            )
//            Column(modifier = Modifier.padding(start = 8.dp)) {
//                Text(
//                    text = movie.title,
//                    style = MaterialTheme.typography.h6
//                )
//                Text(
//                    text = movie.overview,
//                    maxLines = 2,
//                    style = MaterialTheme.typography.body2
//                )
//            }
//        }
//    }
//}
//@Composable
//fun MovieImage(posterPath: String, modifier: Modifier = Modifier) {
//    val imageUrl = "https://image.tmdb.org/t/p/w500$posterPath"
//    AsyncImage(
//        model = imageUrl,
//        contentDescription = null,
//        modifier = modifier
//    )
//}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MovieScreen(movies: List<Result>) {
    var searchQuery by remember { mutableStateOf("") }
    val filteredMovies = movies.filter {
        it.title.contains(searchQuery, ignoreCase = true)
    }

    Column(modifier = Modifier.fillMaxSize()) {
        ImageSlider(movies = movies.take(6)) // Show top 6 movies in the slider
        SearchBar(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            modifier = Modifier.padding(16.dp)
        )
        MovieList(movies = filteredMovies)
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ImageSlider(movies: List<Result>) {
    val pagerState = rememberPagerState()

    HorizontalPager(
        count = movies.size,
        state = pagerState,
        modifier = Modifier
            .height(200.dp)
            .fillMaxWidth()
    ) { page ->
        MovieImage(
            posterPath = movies[page].poster_path,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
fun SearchBar(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier.fillMaxWidth(),
        placeholder = { Text("Search") }
    )
}


@Composable
fun MovieList(movies: List<Result>) {
    LazyColumn {
        items(movies) { movie ->
            MovieItem(movie = movie)
        }
    }
}

@Composable
fun MovieItem(movie: Result) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = 4.dp
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            MovieImage(
                posterPath = movie.poster_path,
                modifier = Modifier.size(70.dp)
            )
            Column(modifier = Modifier.padding(start = 8.dp)) {
                Text(
                    text = movie.title,
                    style = MaterialTheme.typography.h6
                )
                Text(
                    text = movie.overview,
                    maxLines = 2,
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }
}

@Composable
fun MovieImage(posterPath: String, modifier: Modifier = Modifier) {
    val imageUrl = "https://image.tmdb.org/t/p/w500$posterPath"
    AsyncImage(
        model = imageUrl,
        contentDescription = null,
        modifier = modifier
    )
}

