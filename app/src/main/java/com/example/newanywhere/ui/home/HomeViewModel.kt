package com.example.newanywhere.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newanywhere.Retrofit.AreaCode
import com.example.newanywhere.Retrofit.RetrofitClient
import com.example.newanywhere.Retrofit.list
import kotlinx.coroutines.*

class HomeViewModel : ViewModel() {

    private val AreaCodeService = RetrofitClient.AreaCode_Service()
    private val TourService = RetrofitClient.Tour_Service()
//    var AreaCodedata = MutableLiveData<String>()
    var AreaCodedata = MutableLiveData<AreaCode>()
    var TourData = MutableLiveData<list>()
    val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        onError("Exception: ${throwable.localizedMessage}")
    }
    val LoadError = MutableLiveData<String?>()
    fun refresh(areaCode: Int,id :Int) {
        if(id == 0 ){
            getAreaCode()
        }else if(id ==1){
            getTour(areaCode.toString())
        }
    }

    private fun getAreaCode() {
        CoroutineScope(Dispatchers.IO).launch {
            val res = AreaCodeService.getAreacode()
            withContext(Dispatchers.Main) {
                if (res.isSuccessful) {
                    AreaCodedata.postValue(res.body())
                    Log.d("HomeViewModel","getAreaCode : ${res.body()}")
//                    AreaCodedata.postValue(res.body())
                } else {
                    onError("Error: ${res.message()}")
                    Log.d("HomeViewModel", "getAreaCode - Get AreaCode failed : ${res.code()}")
                }
            }

        }

    }

    private fun getTour(areaCode: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val res = TourService.getTour(areaCode)
            withContext(Dispatchers.Main) {
                if (res.isSuccessful) {
                    TourData.postValue(res.body())
                    Log.d("HomeViewModel","getTour : ${res}")
//                    AreaCodedata.postValue(res.body())
                } else {
                    onError("Error: ${res.message()}")
                    Log.d("HomeViewModel", "getAreaCode - Get AreaCode failed : ${res.code()}")
                }
            }

        }

    }
    private fun onError(message: String) {
        LoadError.postValue(message)
    }

}