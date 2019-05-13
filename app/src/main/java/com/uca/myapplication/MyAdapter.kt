package com.uca.myapplication

import com.uca.myapplication.movie.Movie

object AppConstants{
    val dataset_saveinstance_key = "CL"
    val MAIN_LIST_KEY = "key_list"
}

interface MyMovieAdapter {
    fun changeDataSet(newDataSet: List<Movie>)
}