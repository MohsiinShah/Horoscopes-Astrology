package com.astrology.zodiacs.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.astrology.zodiacs.data.repository.MainRepository
import com.astrology.zodiacs.utils.Resource
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class WeeklyViewModel(val mainRepository: MainRepository): ViewModel(){

    fun getHoroscope(sign: String) = liveData(Dispatchers.IO){
        emit(Resource.loading(data = null))
        try{
            emit(
                Resource.success(data = mainRepository.getWeeklyHoroscopes(sign)
            ))
        }catch (e: Exception){
            emit(Resource.error(data = null, message = e.message ?: "Error occurred"))
        }
    }
}