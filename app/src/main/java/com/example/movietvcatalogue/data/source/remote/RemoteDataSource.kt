package com.example.movietvcatalogue.data.source.remote

import com.example.movietvcatalogue.data.MoviesEntity
import com.example.movietvcatalogue.utils.MoviesDataDummy

class RemoteDataSource private constructor(private val jsonHelper: MoviesDataDummy){
    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: MoviesDataDummy): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(helper)
            }
    }

    fun getDataMovies(): List<MoviesEntity> = jsonHelper.generateDummyMovies()

    fun getDataTvShows(): List<MoviesEntity> = jsonHelper.generateDummyTvShows()
}