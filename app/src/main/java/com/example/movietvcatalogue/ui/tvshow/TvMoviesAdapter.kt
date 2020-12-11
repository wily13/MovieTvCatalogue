package com.example.movietvcatalogue.ui.tvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.movietvcatalogue.R
import com.example.movietvcatalogue.data.MoviesEntity
import com.example.movietvcatalogue.databinding.ItemsMoviesBinding
import com.example.movietvcatalogue.ui.detail.DetailMoviesActivity
import kotlin.collections.ArrayList

class TvMoviesAdapter: RecyclerView.Adapter<TvMoviesAdapter.MoviesViewHolder>() {
    private var listMovies = ArrayList<MoviesEntity>()

    fun setMovies(movies: List<MoviesEntity>?) {
        if (movies.isNullOrEmpty()) return
        this.listMovies.clear()
        this.listMovies.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val itemsMoviesBinding =
            ItemsMoviesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesViewHolder(itemsMoviesBinding)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movies = listMovies[position]
        holder.bind(movies)
    }

    override fun getItemCount(): Int = listMovies.size

    inner class MoviesViewHolder(private val binding: ItemsMoviesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movies: MoviesEntity) {
            with(binding) {
                tvItemTitle.text = movies.title
                tvItemDate.text = movies.year.toString()
                tvItemGenre.text = movies.genre
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailMoviesActivity::class.java)
                    intent.putExtra(DetailMoviesActivity.EXTRA_MOVIES, movies.moviesId)
                    intent.putExtra(DetailMoviesActivity.EXTRA_STATUS, "tvshows")
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context)
                    .load(movies.image)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(imgPoster)
            }
        }
    }

}