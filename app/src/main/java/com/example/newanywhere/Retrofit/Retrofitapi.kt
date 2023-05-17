package com.example.newanywhere.Retrofit


import com.example.newanywhere.BuildConfig.TourApi
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

class apiUrl {

    companion object {
        const val TourEndpoint = "areaCode1"
    }

}

interface AreaCode_Interface {
    @GET(apiUrl.TourEndpoint)
    suspend fun getAreacode(
        @Query("_type")
        _type: String = "json",
        @Query("serviceKey")
        key: String = TourApi,
        @Query("numOfRows")
        numOfRows: String = "20",
        @Query("pageNo")
        pageNo: String = "1",
        @Query("MobileOS")
        MobileOS: String = "AND",
        @Query("MobileApp")
        MobileApp: String = "Anywhere",
    ): Response<AreaCode>
}



