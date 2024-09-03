package com.example.itsmovietime.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.itsmovietime.Model.Data.Result
import com.example.itsmovietime.R
import com.example.itsmovietime.ui.EachMovieActivity


class MovieAdapter(
    val context: Context,
):RecyclerView.Adapter<MovieAdapter.MyViewHolder>(){

    private var resultList = ArrayList<Result>()
    fun setMovieList(movieList : List<Result>){
        this.resultList = movieList as ArrayList<Result>
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        val movieTitle: TextView
        val movieImage: ImageView
        val movieOverview: TextView
        val nextButton:AppCompatButton
        init {
            movieTitle=itemView.findViewById(R.id.txtMovieTitle)
            movieOverview=itemView.findViewById(R.id.txtMovieDescription)
            movieImage=itemView.findViewById(R.id.movieImage)
            nextButton=itemView.findViewById(R.id.next)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_design,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return resultList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currItem=resultList[position]

        holder.movieTitle.text=currItem.title
        holder.movieOverview.text=currItem.overview

        //https://image.tmdb.org/t/p/w500  this is the base path to download image
        val posterUrl = "https://image.tmdb.org/t/p/w500" + currItem.poster_path
        Glide.with(context).load(posterUrl).into(holder.movieImage)

        holder.nextButton.setOnClickListener {
            val intent = Intent(context, EachMovieActivity::class.java)
//            intent.putExtra("MOVIE_DETAILS", currItem)
            context.startActivity(intent)
        }
    }


}