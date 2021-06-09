package com.astrology.zodiacs.data.repository

import com.astrology.zodiacs.data.api.ApiHelper

class MainRepository(val apiHelper: ApiHelper) {

    suspend fun getDailyHoroscopes(sign: String) = apiHelper.getDailyHoroscopes(sign)

    suspend fun getWeeklyHoroscopes(sign: String) = apiHelper.getWeeklyHoroscopes(sign)

    suspend fun getMonthlyHoroscopes(sign: String) = apiHelper.getMonthlyHoroscopes(sign)

    suspend fun getYearlyHoroscopes(sign: String) = apiHelper.getYearlyHoroscopes(sign)



}