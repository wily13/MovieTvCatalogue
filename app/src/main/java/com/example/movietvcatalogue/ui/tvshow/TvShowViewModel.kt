package com.example.movietvcatalogue.ui.tvshow

import androidx.lifecycle.ViewModel
import com.example.movietvcatalogue.data.MoviesEntity
import com.example.movietvcatalogue.data.source.MoviesRepository
import com.example.movietvcatalogue.utils.MoviesDataDummy

class TvShowViewModel(private val moviesRepository: MoviesRepository)  : ViewModel() {
//    fun getDataTvShows(): List<MoviesEntity> = MoviesDataDummy.generateDummyTvShows()

    fun getDataTvShows(): List<MoviesEntity> = moviesRepository.getAllTvShows()
}