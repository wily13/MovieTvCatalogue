package com.example.movietvcatalogue.ui.detail

import com.example.movietvcatalogue.data.source.MoviesRepository
import com.example.movietvcatalogue.utils.MoviesDataDummy
import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailMoviesViewModelTest {

    private lateinit var viewModel: DetailMoviesViewModel
    private val dummyMovies = MoviesDataDummy.generateDummyMovies()[0]
    private val dummyTvShows = MoviesDataDummy.generateDummyTvShows()[0]
    private val moviesId = dummyMovies.moviesId

    @Mock
    private lateinit var moviesRepository: MoviesRepository

    @Before
    fun setup() {
        viewModel = DetailMoviesViewModel(moviesRepository)
        viewModel.setSelectedMovies(moviesId)
    }

    @Test
    fun getMoviesDetail() {
        `when`(moviesRepository.getMoviesDetail(moviesId)).thenReturn(dummyMovies)
        val moviesEntity = viewModel.getMoviesDetail()
        verify(moviesRepository).getMoviesDetail(moviesId)
        assertThat(moviesEntity).isNotNull()
        assertThat(dummyMovies.moviesId).isEqualTo(moviesEntity.moviesId)
        assertThat(dummyMovies.title).isEqualTo(moviesEntity.title)
        assertThat(dummyMovies.genre).isEqualTo(moviesEntity.genre)
        assertThat(dummyMovies.year).isEqualTo(moviesEntity.year)
        assertThat(dummyMovies.dateRelease).isEqualTo(moviesEntity.dateRelease)
        assertThat(dummyMovies.description).isEqualTo(moviesEntity.description)
        assertThat(dummyMovies.director).isEqualTo(moviesEntity.director)
        assertThat(dummyMovies.creator).isEqualTo(moviesEntity.creator)
        assertThat(dummyMovies.type).isEqualTo(moviesEntity.type)
        assertThat(dummyMovies.status).isEqualTo(moviesEntity.status)
        assertThat(dummyMovies.language).isEqualTo(moviesEntity.language)
        assertThat(dummyMovies.budget).isEqualTo(moviesEntity.budget)
        assertThat(dummyMovies.revenue).isEqualTo(moviesEntity.revenue)
        assertThat(dummyMovies.image).isEqualTo(moviesEntity.image)
    }

    @Test
    fun getTvShowsDetail() {
        `when`(moviesRepository.getTvShowsDetail(moviesId)).thenReturn(dummyTvShows)
        val tvShowsEntity = viewModel.getTvShowsDetail()
        verify(moviesRepository).getTvShowsDetail(moviesId)
        assertThat(tvShowsEntity).isNotNull()
        assertThat(dummyTvShows.moviesId).isEqualTo(tvShowsEntity.moviesId)
        assertThat(dummyTvShows.title).isEqualTo(tvShowsEntity.title)
        assertThat(dummyTvShows.genre).isEqualTo(tvShowsEntity.genre)
        assertThat(dummyTvShows.year).isEqualTo(tvShowsEntity.year)
        assertThat(dummyTvShows.dateRelease).isEqualTo(tvShowsEntity.dateRelease)
        assertThat(dummyTvShows.description).isEqualTo(tvShowsEntity.description)
        assertThat(dummyTvShows.director).isEqualTo(tvShowsEntity.director)
        assertThat(dummyTvShows.creator).isEqualTo(tvShowsEntity.creator)
        assertThat(dummyTvShows.type).isEqualTo(tvShowsEntity.type)
        assertThat(dummyTvShows.status).isEqualTo(tvShowsEntity.status)
        assertThat(dummyTvShows.language).isEqualTo(tvShowsEntity.language)
        assertThat(dummyTvShows.budget).isEqualTo(tvShowsEntity.budget)
        assertThat(dummyTvShows.revenue).isEqualTo(tvShowsEntity.revenue)
        assertThat(dummyTvShows.image).isEqualTo(tvShowsEntity.image)
    }
}