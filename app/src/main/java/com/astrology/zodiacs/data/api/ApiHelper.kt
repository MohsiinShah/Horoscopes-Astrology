package com.astrology.zodiacs.data.api

class ApiHelper(val apiService: ApiService) {

    suspend fun getDailyHoroscopes(sign: String) = apiService.getDailyHoroscopes(sign)

    suspend fun getWeeklyHoroscopes(sign: String) = apiService.getWeeklyHoroscopes(sign)

    suspend fun getMonthlyHoroscopes(sign: String) = apiService.getMonthlyHoroscopes(sign)

    suspend fun getYearlyHoroscopes(sign: String) = apiService.getYearlyHoroscopes(sign)
}