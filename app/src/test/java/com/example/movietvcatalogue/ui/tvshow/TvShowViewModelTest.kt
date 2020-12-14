package com.example.movietvcatalogue.ui.tvshow

import com.example.movietvcatalogue.data.MoviesEntity
import com.example.movietvcatalogue.data.source.MoviesRepository
import com.example.movietvcatalogue.utils.MoviesDataDummy
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel

    @Mock
    private lateinit var moviesRepository: MoviesRepository

    @Before
    fun setup(){
        viewModel = TvShowViewModel(moviesRepository)
    }

    @Test
    fun getDataTvShows() {
        `when`(moviesRepository.getAllTvShows()).thenReturn(MoviesDataDummy.generateDummyTvShows() as ArrayList<MoviesEntity>)
        val tvShowsEntities = viewModel.getDataTvShows()
        verify(moviesRepository).getAllTvShows()
        assertThat(tvShowsEntities).isNotNull()
        assertThat(tvShowsEntities.size).isEqualTo(14)
    }

}