package com.example.movietvcatalogue.data.source.remote.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MoviesResponse (
    val id: String,
    var title: String,
    var genre: String,
    var year: Int,
    var dateRelease: String,
    var description: String,
    var director: String,
    var creator: String,
    var type: String,
    var status: String,
    var language: String,
    var budget: Double,
    var revenue: Double,
    var image: Int
): Parcelable