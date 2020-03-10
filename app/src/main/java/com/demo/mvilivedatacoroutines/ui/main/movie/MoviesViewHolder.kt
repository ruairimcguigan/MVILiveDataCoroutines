package com.demo.mvilivedatacoroutines.ui.main.movie

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.demo.mvilivedatacoroutines.R
import kotlinx.android.synthetic.main.movie_list_item.view.*

class MoviesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    fun bind(
        context: Context,
        listener: (Movie) -> Unit,
        movie: Movie) {

        itemView.apply {
            movieTitle.text = movie.title
            movieDescription.text = movie.overview
            releaseDate.text = context.getString(
                R.string.movies_release_date,
                movie.releaseDate
            )

            movie.posterPath?.run {
                Glide
                    .with(context)
                    .load(getImageUrl(this))
                    .into(movieImage)
            }

            setOnClickListener { listener.invoke(movie) }
        }
    }

    fun getImageUrl(imagePath: String) = "https://image.tmdb.org/t/p/w185$imagePath"

}
