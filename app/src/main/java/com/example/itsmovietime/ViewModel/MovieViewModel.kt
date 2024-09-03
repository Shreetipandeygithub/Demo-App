package com.example.itsmovietime.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.itsmovietime.Model.Data.MyMovieData
import com.example.itsmovietime.Api.RetrofitHelper
import com.example.itsmovietime.Model.Data.Result
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViewModel:ViewModel() {
    private var movieLiveData = MutableLiveData<List<Result>>()


    fun getMyMovieData(){
        val retrofitData= RetrofitHelper.retrofitBuilder

        retrofitData.enqueue(object :Callback<MyMovieData?>{
            override fun onResponse(call: Call<MyMovieData?>, response: Response<MyMovieData?>) {
                val responseBody=response.body()
                if(response.isSuccessful && responseBody!=null){
                    movieLiveData.value=responseBody.results
                }
            }

            override fun onFailure(call: Call<MyMovieData?>, t: Throwable) {
                t.printStackTrace()
            }

        })
    }
    fun observeMovieLiveData() : LiveData<List<Result>>{
        return movieLiveData
    }
}