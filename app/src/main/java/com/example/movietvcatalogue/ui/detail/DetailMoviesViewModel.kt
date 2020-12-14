package com.example.movietvcatalogue.ui.detail

import androidx.lifecycle.ViewModel
import com.example.movietvcatalogue.data.MoviesEntity
import com.example.movietvcatalogue.data.source.MoviesRepository
import com.example.movietvcatalogue.utils.MoviesDataDummy

class DetailMoviesViewModel(private val moviesRepository: MoviesRepository) : ViewModel() {

    private lateinit var moviesId: String

    fun setSelectedMovies(moviesId: String) {
        this.moviesId = moviesId
    }

//    fun getMoviesDetail(): MoviesEntity {
//        lateinit var movies: MoviesEntity
//        val moviesEntities = MoviesDataDummy.generateDummyMovies()
//        for (moviesEntity in moviesEntities) {
//            if (moviesEntity.moviesId == moviesId) {
//                movies = moviesEntity
//            }
//        }
//        return movies
//    }
//
//    fun getTvShowsDetail(): MoviesEntity {
//        lateinit var movies: MoviesEntity
//        val moviesEntities = MoviesDataDummy.generateDummyTvShows()
//        for (moviesEntity in moviesEntities) {
//            if (moviesEntity.moviesId == moviesId) {
//                movies = moviesEntity
//            }
//        }
//        return movies
//    }

    fun getMoviesDetail(): MoviesEntity = moviesRepository.getMoviesDetail(moviesId)
    fun getTvShowsDetail(): MoviesEntity = moviesRepository.getTvShowsDetail(moviesId)
}