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

//    fun getMovieData(
//        @Query("api_key") apiKey: String,
//        @Query("category") category:String,
//        @Query("page") page:Int
//    )
//
//    companion object{
//        const val base_URL="https://api.themoviedb.org/3/"
//        const val apiKey="38a73d59546aa378980a88b645f487fc"
//        const val image_base_url="https://image.tmdb.org/t/p/w500"
//    }
}