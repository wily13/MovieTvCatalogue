package com.example.movietvcatalogue.ui.detail

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.movietvcatalogue.R
import com.example.movietvcatalogue.data.MoviesEntity
import com.example.movietvcatalogue.databinding.ActivityDetailMoviesBinding
import com.example.movietvcatalogue.databinding.ContentDetailMoviesBinding
import com.example.movietvcatalogue.utils.FormatedMethod
import com.example.movietvcatalogue.viewmodel.ViewModelFactory
import java.lang.StringBuilder


class DetailMoviesActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIES = "extra_movies"
        const val EXTRA_STATUS = "extra_status"
        const val EXTRA_TITLE_TAB = "movies"
    }

    private lateinit var contentDetailMoviesBinding: ContentDetailMoviesBinding
    private lateinit var activityDetailMoviesBinding: ActivityDetailMoviesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDetailMoviesBinding = ActivityDetailMoviesBinding.inflate(layoutInflater)
        contentDetailMoviesBinding = activityDetailMoviesBinding.moviesContent
        setContentView(activityDetailMoviesBinding.root)

        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory).get(
            DetailMoviesViewModel::class.java
        )

        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getString(EXTRA_MOVIES)
            val movieStatus = extras.getString(EXTRA_STATUS)
            if (movieId != null) {
                viewModel.setSelectedMovies(movieId)
                if (movieStatus == EXTRA_TITLE_TAB) {
                    populateMoview(viewModel.getMoviesDetail(), movieStatus)
                    supportActionBar?.title = getString(R.string.title_tab_movies)
                } else {
                    movieStatus?.let { populateMoview(viewModel.getTvShowsDetail(), it) }
                    supportActionBar?.title = getString(R.string.title_tab_tvshows)
                }
            }
        }

    }

    @SuppressLint("SetTextI18n")
    private fun populateMoview(movies: MoviesEntity, movieStatus: String) {
        movies.apply {
            with(contentDetailMoviesBinding) {
                tvTitle.text = StringBuilder("$title ($year)")
                tvGenre.text = genre
                tvDescription.text = description
                tvDirector.text = director
                tvCreator.text = creator
                tvType.text = type
                tvStatus.text = status
                tvLanguage.text = language

                if (movieStatus == "movies") {
                    tvDaterelease.text = FormatedMethod.getDateRilease(dateRelease)
                    tvBudget.text = FormatedMethod.roundOffDecimal(budget)
                    tvRevenue.text = FormatedMethod.roundOffDecimal(revenue)

                    tvCreator.isVisible = false
                    tvCreatorTitle.isVisible = false
                    tvType.isVisible = false
                    tvTypeTitle.isVisible = false
                } else {
                    tvDaterelease.isVisible = false
                    tvDatereleaseTitle.isVisible = false
                    tvDirector.isVisible = false
                    tvDirectorTitle.isVisible = false
                    tvBudget.isVisible = false
                    tvBudgetTitle.isVisible = false
                    tvRevenue.isVisible = false
                    tvRevenueTitle.isVisible = false
                }

                activityDetailMoviesBinding.fab.setOnClickListener {
                    shareApp(title)
                }

                Glide.with(this@DetailMoviesActivity)
                    .load(image)
                    .transform(RoundedCorners(20))
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(imgPoster)
            }
        }
    }

    private fun shareApp(title: String) {
        val mimeType = "text/plain"
        ShareCompat.IntentBuilder
            .from(this@DetailMoviesActivity)
            .setType(mimeType)
            .setChooserTitle("Bagikan Film: \"${title}\" ini sekarang.")
            .startChooser()
    }


}

