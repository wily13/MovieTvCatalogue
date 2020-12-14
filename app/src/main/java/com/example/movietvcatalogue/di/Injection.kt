package com.example.movietvcatalogue.di

import android.content.Context
import com.example.movietvcatalogue.data.source.MoviesRepository
import com.example.movietvcatalogue.data.source.remote.RemoteDataSource
import com.example.movietvcatalogue.utils.MoviesDataDummy

object Injection {
    fun provideRepository(context: Context): MoviesRepository {

        val remoteDataSource = RemoteDataSource.getInstance(MoviesDataDummy)

        return MoviesRepository.getInstance(remoteDataSource)
    }
}