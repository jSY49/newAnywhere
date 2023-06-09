package com.example.newanywhere

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newanywhere.Retrofit.AreaCode
import com.example.newanywhere.Retrofit.Detail
import com.example.newanywhere.Retrofit.DetailItem
import com.example.newanywhere.Retrofit.RetrofitClient.Detail_Service
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailItemViewModel : ViewModel() {

    var data = MutableLiveData<DetailItem>()

    fun refresh(itemId: String) {
        getItemDetail((itemId))
    }

    private fun getItemDetail(itemId: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val res = Detail_Service().getDetail(itemId)
            withContext(Dispatchers.Main) {
                if (res.isSuccessful) {
                    data.postValue(res.body()?.response?.body?.items?.item?.get(0))
                    Log.d("DetailItemViewModel","getItemDetail : ${res}")
//                    AreaCodedata.postValue(res.body())
                } else {
                    Log.d("HomeViewModel", "getAreaCode - Get AreaCode failed : ${res.code()}")
                }
            }

        }
    }

}