package com.example.movietvcatalogue.ui.tvshow

import androidx.lifecycle.ViewModel
import com.example.movietvcatalogue.data.MoviesEntity
import com.example.movietvcatalogue.utils.MoviesDataDummy

class TvShowViewModel : ViewModel() {
    fun getDataTvShows(): List<MoviesEntity> = MoviesDataDummy.generateDummyTvShows()
}