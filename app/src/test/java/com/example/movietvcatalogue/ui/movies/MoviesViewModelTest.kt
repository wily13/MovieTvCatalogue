package com.example.movietvcatalogue.ui.movies

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.Before

class MoviesViewModelTest {

    private lateinit var viewModel: MoviesViewModel

    @Before
    fun setup(){
        viewModel = MoviesViewModel()
    }

    @Test
    fun getDataMovies() {
        val moviesEntities = viewModel.getDataMovies()
        assertThat(moviesEntities).isNotNull()
        assertThat(moviesEntities.size).isEqualTo(17)
    }

}