package com.example.movietvcatalogue.data.source

import com.example.movietvcatalogue.data.MoviesEntity
import com.example.movietvcatalogue.data.source.remote.RemoteDataSource
import com.example.movietvcatalogue.utils.MoviesDataDummy
import com.google.common.truth.Truth
import org.junit.Test

import org.junit.Assert.*
import org.mockito.Mockito
import org.mockito.Mockito.`when`

class MoviesRepositoryTest {

    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val academyRepository = FakeMoviesRepository(remote)

    private val moviesResponses = MoviesDataDummy.generateRemoteDummyMovies()
    private val moviesId = moviesResponses[0].moviesId
    private val tvShowsResponses = MoviesDataDummy.generateRemoteDummyTvShows()
    private val tvShowsId = tvShowsResponses[0].moviesId

    @Test
    fun getAllMovies() {

    }

    @Test
    fun getAllTvShows() {
    }

    @Test
    fun getMoviesDetail() {
    }

    @Test
    fun getTvShowsDetail() {
    }
}