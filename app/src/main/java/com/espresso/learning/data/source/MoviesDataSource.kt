package com.espresso.learning.data.source

import com.espresso.learning.data.Movie

interface MoviesDataSource {

    fun getMovie(movieId: Int): Movie?
}