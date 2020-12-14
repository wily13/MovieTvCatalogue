package com.example.movietvcatalogue.ui.movies

import androidx.lifecycle.ViewModel
import com.example.movietvcatalogue.data.MoviesEntity
import com.example.movietvcatalogue.data.source.MoviesRepository
import com.example.movietvcatalogue.utils.MoviesDataDummy

class MoviesViewModel(private val moviesRepository: MoviesRepository) : ViewModel() {
//    fun getDataMovies(): List<MoviesEntity> = MoviesDataDummy.generateDummyMovies()

    fun getDataMovies(): List<MoviesEntity> = moviesRepository.getAllMovies()
}