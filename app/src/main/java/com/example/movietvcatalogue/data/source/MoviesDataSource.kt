package com.example.movietvcatalogue.data.source

import com.example.movietvcatalogue.data.MoviesEntity

interface MoviesDataSource {
    fun getAllMovies(): List<MoviesEntity>

    fun getAllTvShows(): List<MoviesEntity>

    fun getMoviesDetail(moviesId: String): MoviesEntity

    fun getTvShowsDetail(tvShowsId: String): MoviesEntity
}