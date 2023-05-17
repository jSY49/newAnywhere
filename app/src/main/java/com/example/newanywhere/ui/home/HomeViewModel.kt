package com.example.newanywhere.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newanywhere.Retrofit.AreaCode
import com.example.newanywhere.Retrofit.RetrofitClient
import kotlinx.coroutines.*

class HomeViewModel : ViewModel() {

    private val AreaCodeService = RetrofitClient.AreaCode_Service()
//    var AreaCodedata = MutableLiveData<String>()
    var AreaCodedata = MutableLiveData<AreaCode>()
    val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        onError("Exception: ${throwable.localizedMessage}")
    }
    val LoadError = MutableLiveData<String?>()
    fun Arearefresh() {
        getAreaCode()
    }

    private fun getAreaCode() {
        CoroutineScope(Dispatchers.IO).launch {
            val res = AreaCodeService.getAreacode()
            withContext(Dispatchers.Main) {
                Log.d("HomeViewModel", "getAreaCode : ${res.toString()}")
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

    private fun onError(message: String) {
        LoadError.postValue(message)
    }

}