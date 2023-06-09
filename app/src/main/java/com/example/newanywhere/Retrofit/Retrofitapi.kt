package com.example.newanywhere.Retrofit


import com.example.newanywhere.BuildConfig.TourApi
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

class apiUrl {

    companion object {
        const val areaCodeEndpoint = "areaCode1"
        const val TourEndpoint = "areaBasedList1"
        const val DetailEndPoint = "detailCommon1"
    }
}

interface AreaCode_Interface {
    @GET(apiUrl.areaCodeEndpoint)
    suspend fun getAreacode(
        @Query("_type") _type: String = "json",
        @Query("serviceKey") key: String = TourApi,
        @Query("numOfRows") numOfRows: String = "20",
        @Query("pageNo") pageNo: String = "1",
        @Query("MobileOS") MobileOS: String = "AND",
        @Query("MobileApp") MobileApp: String = "Anywhere",
    ): Response<AreaCode>
}

interface Tour_Interface {
    @GET(apiUrl.TourEndpoint)
    suspend fun getTour(
        @Query("areaCode") areaCode: String,
        @Query("_type") _type: String = "json",
        @Query("serviceKey") key: String = TourApi,
        @Query("numOfRows") numOfRows: String = "20",
        @Query("pageNo") pageNo: String = "1",
        @Query("MobileOS") MobileOS: String = "AND",
        @Query("MobileApp") MobileApp: String = "Anywhere",
        @Query("arrange") arrange: String = "O",
        @Query("contentTypeId") contentTypeId: String = "12",

        ): Response<list>
}

interface Detail_Interface {
    @GET(apiUrl.DetailEndPoint)
    suspend fun getDetail(
        @Query("contentId") contentId: String,
        @Query("_type") _type: String = "json",
        @Query("serviceKey") key: String = TourApi,
        @Query("MobileOS") MobileOS: String = "AND",
        @Query("MobileApp") MobileApp: String = "Anywhere",
        @Query("defaultYN") defaultYN: String = "Y",
        @Query("addrinfoYN") addrinfoYN: String = "Y",
        @Query("firstImageYN") firstImageYN: String = "Y",
        @Query("areacodeYN") areacodeYN: String = "Y",
        @Query("mapinfoYN") mapinfoYN: String = "Y",
        @Query("overviewYN") overviewYN: String = "Y",
    ): Response<Detail>
}

