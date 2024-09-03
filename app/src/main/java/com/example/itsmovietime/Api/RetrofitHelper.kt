package com.example.itsmovietime.Api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    private const val base_URL="https://api.themoviedb.org/3/"
    private const val apiKey="38a73d59546aa378980a88b645f487fc"

        val retrofitBuilder= Retrofit.Builder()
            .baseUrl(base_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieApiInterface::class.java)
            .getMovieData(apiKey)
}