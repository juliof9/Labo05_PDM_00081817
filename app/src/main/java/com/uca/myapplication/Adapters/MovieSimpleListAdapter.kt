package com.uca.myapplication.Adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.uca.myapplication.MyMovieAdapter
import com.uca.myapplication.R
import com.uca.myapplication.movie.Movie
import kotlinx.android.synthetic.main.list_item_movie.view.*

class MovieSimpleListAdapter(var movies:List<Movie>, val clickListener: (Movie) -> Unit): RecyclerView.Adapter<MovieSimpleListAdapter.ViewHolder>(),
    MyMovieAdapter {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_movie, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: ViewHolder, pos: Int) =holder.bind(movies[pos], clickListener)

    override fun changeDataSet(newDataSet: List<Movie>) {
        this.movies = newDataSet
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(movie: Movie, clickListener: (Movie) -> Unit) = with(itemView){
            title_list_item.text = movie.Name
            tipo1_list_item_movie.text = movie.Type1
            tipo2_list_item_movie.text = movie.Type2
            this.setOnClickListener { clickListener(movie) }
        }
    }
}