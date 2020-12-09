package com.example.movietvcatalogue.ui.movies

import androidx.lifecycle.ViewModel
import com.example.movietvcatalogue.data.MoviesEntity
import com.example.movietvcatalogue.utils.MoviesDataDummy

class MoviesViewModel: ViewModel() {
    fun getDataMovies(): List<MoviesEntity> = MoviesDataDummy.generateDummyMovies()
}