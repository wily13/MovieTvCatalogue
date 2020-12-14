package com.example.movietvcatalogue.data.source

import com.example.movietvcatalogue.data.MoviesEntity

interface MoviesDataSource {
    fun getDataMovies(): List<MoviesEntity>

    fun getDataTvShows(): List<MoviesEntity>

    fun getMoviesDetail(): MoviesEntity

    fun getTvShowsDetail(): MoviesEntity
}