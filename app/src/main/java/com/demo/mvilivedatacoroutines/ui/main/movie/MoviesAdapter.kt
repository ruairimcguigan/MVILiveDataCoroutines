package com.demo.mvilivedatacoroutines.ui.main.movie

import android.content.Context
import android.view.LayoutInflater.from
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.demo.mvilivedatacoroutines.R.layout.movie_list_item

class MoviesAdapter(private val listener: (Movie) -> Unit)
    : ListAdapter<Movie, MoviesViewHolder>(MovieDiffCallback()) {

    private lateinit var context: Context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int): MoviesViewHolder {

        context = parent.context
        return MoviesViewHolder(from(context).inflate(
            movie_list_item,
            parent,
            false)
        )
    }

    override fun onBindViewHolder(
        holder: MoviesViewHolder,
        position: Int) = holder.bind(
        context,
        listener,
        getItem(position)
    )

    class MovieDiffCallback : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(
            oldItem: Movie,
            newItem: Movie): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: Movie,
            newItem: Movie): Boolean {
            return oldItem == newItem
        }
    }
}