package com.example.movietvcatalogue.utils

import android.annotation.SuppressLint
import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.SimpleDateFormat

object FormatedMethod {

    @SuppressLint("SimpleDateFormat")
    fun getDateRilease(date: String): String? {
        val parser =  SimpleDateFormat("MM/dd/yyyy")
        val formatter = SimpleDateFormat("MMMM dd, yyyy")
        val formattedDate = formatter.format(parser.parse(date))

        return formattedDate
    }

    fun roundOffDecimal(number: Double): String {
        val df = DecimalFormat("#,###.##")
        df.roundingMode = RoundingMode.CEILING
        return df.format(number)
    }
}