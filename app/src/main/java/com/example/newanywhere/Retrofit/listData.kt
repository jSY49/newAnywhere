package com.example.newanywhere.Retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class list(
    @Expose
    @SerializedName("response")
    var response: listResponse
)

data class listResponse(
    @Expose
    @SerializedName("header")
    var header: listHeader,
    @Expose
    @SerializedName("body")
    var body: listBody
)

data class listBody(
    @Expose
    @SerializedName("items")
    var items: listItems,
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

data class listItems(
    @Expose
    @SerializedName("item")
    var item: List<listItem>
)

data class listItem(
    @Expose
    @SerializedName("addr1")
    val addr1: String,
    @Expose
    @SerializedName("addr2")
    val addr2: String,
    @Expose
    @SerializedName("areacode")
    val areacode: String,
    @Expose
    @SerializedName("booktour")
    val booktour: String,
    @Expose
    @SerializedName("cat1")
    val cat1: String,
    @Expose
    @SerializedName("cat2")
    val cat2: String,
    @Expose
    @SerializedName("cat3")
    val cat3: String,
    @Expose
    @SerializedName("contentid")
    val contentid: String,
    @Expose
    @SerializedName("contenttypeid")
    val contenttypeid: String,
    @Expose
    @SerializedName("createdtime")
    val createdtime: String,
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
    @SerializedName("mapx")
    val mapx: String,
    @Expose
    @SerializedName("mapy")
    val mapy: String,
    @Expose
    @SerializedName("mlevel")
    val mlevel: String,
    @Expose
    @SerializedName("modifiedtime")
    val modifiedtime: String,
    @Expose
    @SerializedName("sigungucode")
    val sigungucode: String,
    @Expose
    @SerializedName("tel")
    val tel: String,
    @Expose
    @SerializedName("title")
    val title: String,
    @Expose
    @SerializedName("zipcode")
    val zipcode: String
)

data class listHeader(
    @Expose
    @SerializedName("resultCode")
    val resultCode: String,
    @Expose
    @SerializedName("resultMsg")
    val resultMsg: String
)