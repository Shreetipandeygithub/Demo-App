package com.example.itsmovietime.Api

import com.example.itsmovietime.Model.Data.MyMovieData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiInterface {

    @GET("movie/popular")
    fun getMovieData(
        @Query("api_key") apiKey: String
    ): Call<MyMovieData>

}