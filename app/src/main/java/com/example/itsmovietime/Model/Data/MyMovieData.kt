package com.example.itsmovietime.Model.Data

data class MyMovieData(
    val dates: Dates,
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)