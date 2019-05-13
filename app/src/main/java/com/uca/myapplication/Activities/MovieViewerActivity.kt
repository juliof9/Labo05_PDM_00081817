package com.uca.myapplication.Activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.uca.myapplication.R
import com.bumptech.glide.Glide
import com.uca.myapplication.movie.Movie
import kotlinx.android.synthetic.main.viewer_movie.*

class MovieViewerActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.viewer_movie)

        val mIntent = intent

        if(mIntent!=null){

            val receiver: Movie = intent?.extras?.getParcelable("MOVIE") ?:Movie(R.string.n_a_value.toString(),
                R.string.n_a_value.toString(),
                R.string.n_a_value.toString(),
                R.string.n_a_value.toString(),
                R.string.n_a_value.toString())
            init(receiver)
        }
    }

    fun init(movie: Movie){
        Glide.with(this)
            .load(movie.sprite)
            .placeholder(R.drawable.ic_launcher_background)
            .dontAnimate()
            .into(app_bar_image_viewer)
        Nombre_viewer.text = movie.Name
        type1_viewer.text = movie.Type1
        type2_viewer.text = movie.Type2
        weight_viewer.text = movie.weight

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home -> {onBackPressed();true}
            else -> super.onOptionsItemSelected(item)
        }
    }
}