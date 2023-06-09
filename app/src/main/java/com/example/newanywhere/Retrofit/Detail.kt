package com.example.newanywhere.Retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Detail(
    @Expose
    @SerializedName("response")
    var response: DetailResponse
)

data class DetailResponse(
    @Expose
    @SerializedName("header")
    var header: DetailHeader,
    @Expose
    @SerializedName("body")
    var body: DetailBody
)

data class DetailBody(
    @Expose
    @SerializedName("items")
    var items: DetailItems,
    @Expose
    @SerializedName("numOfRows")
    var numOfRows: Int,
    @Expose
    @SerializedName("pageNo")
    var pageNo: Int,
    @Expose
    @SerializedName("totalCount")
    var totalCount: Int
)

data class DetailItems(
    @Expose
    @SerializedName("item")
    var item: List<DetailItem>
)

data class DetailItem(
    @Expose
    @SerializedName("contentid")
    val contentid: String,
    @Expose
    @SerializedName("contenttypeid")
    val contenttypeid: String,
    @Expose
    @SerializedName("title")
    val title: String,
    @Expose
    @SerializedName("createdtime")
    val createdtime: String,
    @Expose
    @SerializedName("modifiedtime")
    val modifiedtime: String,
    @Expose
    @SerializedName("tel")
    val tel: String,
    @Expose
    @SerializedName("telname")
    val telname: String,
    @Expose
    @SerializedName("homepage")
    val homepage: String,
    @Expose
    @SerializedName("booktour")
    val booktour: String,
    @Expose
    @SerializedName("firstimage")
    val firstimage: String,
    @Expose
    @SerializedName("firstimage2")
    val firstimage2: String,
    @Expose
    @SerializedName("cpyrhtDivCd")
    val cpyrhtDivCd: String,
    @Expose
    @SerializedName("areacode")
    val areacode: String,
    @Expose
    @SerializedName("sigungucode")
    val sigungucode: String,
    @Expose
    @SerializedName("addr1")
    val addr1: String,
    @Expose
    @SerializedName("addr2")
    val addr2: String,
    @Expose
    @SerializedName("zipcode")
    val zipcode: String,
    @Expose
    @SerializedName("mapx")
    val mapx: String,
    @Expose
    @SerializedName("mapy")
    val mapy: String,
    @Expose
    @SerializedName("mlevel")
    val mlevel: String,
    @Expose
    @SerializedName("overview")
    val overview: String
)

data class DetailHeader(
    @Expose
    @SerializedName("resultCode")
    val resultCode: String,
    @Expose
    @SerializedName("resultMsg")
    val resultMsg: String
)
