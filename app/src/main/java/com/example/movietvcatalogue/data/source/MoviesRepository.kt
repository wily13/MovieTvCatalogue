package com.example.movietvcatalogue.data.source

import com.example.movietvcatalogue.data.MoviesEntity
import com.example.movietvcatalogue.data.source.remote.RemoteDataSource

class MoviesRepository private constructor(private val remoteDataSource: RemoteDataSource) : MoviesDataSource {

    companion object {
        @Volatile
        private var instance: MoviesRepository? = null

        fun getInstance(remoteData: RemoteDataSource): MoviesRepository =
            instance ?: synchronized(this) {
                instance ?: MoviesRepository(remoteData)
            }
    }

    override fun getAllMovies(): List<MoviesEntity> {
        val courseResponses = remoteDataSource.getDataMovies()
        val moviesList = ArrayList<MoviesEntity>()
        for (response in courseResponses) {
            val movies = MoviesEntity(response.moviesId,
                response.title,
                response.genre,
                response.year,
                response.dateRelease,
                response.description,
                response.director,
                response.creator,
                response.type,
                response.status,
                response.language,
                response.budget,
                response.revenue,
                response.image)
            moviesList.add(movies)
        }
        return moviesList
    }

    override fun getAllTvShows(): List<MoviesEntity> {
        val courseResponses = remoteDataSource.getDataTvShows()
        val tvShowsList = ArrayList<MoviesEntity>()
        for (response in courseResponses) {
            val tvShows = MoviesEntity(response.moviesId,
                response.title,
                response.genre,
                response.year,
                response.dateRelease,
                response.description,
                response.director,
                response.creator,
                response.type,
                response.status,
                response.language,
                response.budget,
                response.revenue,
                response.image)
            tvShowsList.add(tvShows)
        }
        return tvShowsList
    }

    override fun getMoviesDetail(moviesId: String): MoviesEntity {
        val courseResponses = remoteDataSource.getDataMovies()
        lateinit var movies: MoviesEntity
        for (response in courseResponses) {
            if (response.moviesId == moviesId) {
                movies = MoviesEntity(response.moviesId,
                    response.title,
                    response.genre,
                    response.year,
                    response.dateRelease,
                    response.description,
                    response.director,
                    response.creator,
                    response.type,
                    response.status,
                    response.language,
                    response.budget,
                    response.revenue,
                    response.image)
            }
        }
        return movies
    }

    override fun getTvShowsDetail(tvShowsId: String): MoviesEntity {
        val courseResponses = remoteDataSource.getDataTvShows()
        lateinit var tvShows: MoviesEntity
        for (response in courseResponses) {
            if (response.moviesId == tvShowsId) {
                tvShows = MoviesEntity(response.moviesId,
                    response.title,
                    response.genre,
                    response.year,
                    response.dateRelease,
                    response.description,
                    response.director,
                    response.creator,
                    response.type,
                    response.status,
                    response.language,
                    response.budget,
                    response.revenue,
                    response.image)
            }
        }
        return tvShows
    }
}