package com.example.movietvcatalogue.ui.tvshow

import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel

    @Before
    fun setup(){
        viewModel = TvShowViewModel()
    }

    @Test
    fun getDataTvShows() {
        val tvShowsEntities = viewModel.getDataTvShows()
        assertThat(tvShowsEntities).isNotNull()
        assertThat(tvShowsEntities.size).isEqualTo(14)
    }

}