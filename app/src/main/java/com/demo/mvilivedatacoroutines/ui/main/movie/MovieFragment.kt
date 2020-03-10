package com.demo.mvilivedatacoroutines.ui.main.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.demo.mvilivedatacoroutines.R
import com.demo.mvilivedatacoroutines.R.layout.movies_fragment
import com.demo.mvilivedatacoroutines.ui.main.base.BaseFragment
import com.demo.mvilivedatacoroutines.ui.main.base.BaseViewState
import kotlinx.android.synthetic.main.movie_list_item.*
import kotlinx.android.synthetic.main.movies_fragment.*

class MovieFragment : BaseFragment() {

    companion object {
        const val MOVIE_KEY = "movie"
        const val MOVIE_IMAGE_VALUE ="posterImage"
    }

    private val viewModel: MoviesViewModel by viewModels { viewModelFactory }
    private val moviesAdapter = MoviesAdapter(::onMovieSelected)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View {

        return inflater.inflate(
            movies_fragment,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initMoviesList()
        observeViewState()
    }

    private fun initMoviesList() {
        moviesList.apply {
            layoutManager = LinearLayoutManager(
                context,
                VERTICAL,
                false
            )
            adapter = moviesAdapter
            setHasFixedSize(true)
        }
    }

    private fun observeViewState() = viewModel.moviesViewState.observe(this) { render(it) }

    override fun render(state: BaseViewState) {
        state as MoviesViewState

        if (state.error != null) {
            Toast.makeText(context, state.error.localizedMessage, Toast.LENGTH_SHORT).show()
        } else {
            progressBar.isVisible = state.isLoading
            moviesAdapter.submitList(state.movies)
        }
    }

    private fun onMovieSelected(movie: Movie) {
        findNavController().navigate(
            R.id.detailAction,
            bundleOf(MOVIE_KEY to movie),
            null,
            FragmentNavigatorExtras(movieImage to MOVIE_IMAGE_VALUE)
        )
    }
}
