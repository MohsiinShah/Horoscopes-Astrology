package com.astrology.zodiacs.data.api

import com.astrology.zodiacs.data.model.HoroscopeResponse
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("horoscope/today/{sign}")
    suspend fun getDailyHoroscopes(@Path("sign") sign: String) : HoroscopeResponse

    @GET("horoscope/week/{sign}")
    suspend fun getWeeklyHoroscopes(@Path("sign") sign: String): HoroscopeResponse

    @GET("horoscope/month/{sign}")
    suspend fun getMonthlyHoroscopes(@Path("sign") sign: String) : HoroscopeResponse

    @GET("horoscope/year/{sign}")
    suspend fun getYearlyHoroscopes(@Path("sign") sign: String) : HoroscopeResponse
}