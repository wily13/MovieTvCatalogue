package com.example.movietvcatalogue.ui.movies

import com.example.movietvcatalogue.data.MoviesEntity
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
class MoviesViewModelTest {

    private lateinit var viewModel: MoviesViewModel

    @Mock
    private lateinit var moviesRepository: MoviesRepository

    @Before
    fun setup(){
        viewModel = MoviesViewModel(moviesRepository)
    }

    @Test
    fun getDataMovies() {
        `when`(moviesRepository.getAllMovies()).thenReturn(MoviesDataDummy.generateDummyMovies() as ArrayList<MoviesEntity>)
        val moviesEntities = viewModel.getDataMovies()
        verify(moviesRepository).getAllMovies()
        assertThat(moviesEntities).isNotNull()
        assertThat(moviesEntities.size).isEqualTo(17)
    }

}