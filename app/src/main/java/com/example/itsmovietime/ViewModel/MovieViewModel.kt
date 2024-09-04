package com.example.itsmovietime.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.itsmovietime.Api.RetrofitHelper
import com.example.itsmovietime.Model.Data.Result
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


//class MovieViewModel : ViewModel() {
//    private val _movieStateFlow = MutableStateFlow<List<Result>>(emptyList())
//    val movieStateFlow: StateFlow<List<Result>> = _movieStateFlow
//
//    fun getMyMovieData() {
//        viewModelScope.launch {
//            try {
//                val response = RetrofitHelper.retrofitBuilder.execute()
//                if (response.isSuccessful) {
//                    response.body()?.results?.let { results ->
//                        _movieStateFlow.value = results
//                    }
//                }
//            } catch (e: Exception) {
//                // Handle error
//            }
//        }
//    }
//
//    fun observeMovieLiveData(): StateFlow<List<Result>> = movieStateFlow
//}

class MovieViewModel : ViewModel() {
    private val _movieStateFlow = MutableStateFlow<List<Result>>(emptyList())
    val movieStateFlow: StateFlow<List<Result>> = _movieStateFlow

    fun getMyMovieData() {
        viewModelScope.launch {
            try {
                val response = RetrofitHelper.retrofitBuilder.execute()
                if (response.isSuccessful) {
                    response.body()?.results?.let { results ->
                        _movieStateFlow.value = results
                    }
                }
            } catch (e: Exception) {
                // Handle error
            }
        }
    }

    fun observeMovieLiveData(): StateFlow<List<Result>> = movieStateFlow
}



