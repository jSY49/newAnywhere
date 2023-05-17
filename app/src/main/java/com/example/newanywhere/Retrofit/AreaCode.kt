package com.example.newanywhere.Retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class AreaCode(
    @Expose
    @SerializedName("response")
    var response: Response
)

data class Response(
    @Expose
    @SerializedName("header")
    var header: Header,
    @Expose
    @SerializedName("body")
    var body: Body
)

data class Body(
    @Expose
    @SerializedName("items")
    var items: Items,
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

data class Items(
    @Expose
    @SerializedName("item")
    var item: List<Item>
)

data class Item(
    @Expose
    @SerializedName("rnum")
    var rnum: Int,
    @Expose
    @SerializedName("code")
    val code: String,
    @Expose
    @SerializedName("name")
    val name: String
)

data class Header(
    @Expose
    @SerializedName("resultCode")
    val resultCode: String,
    @Expose
    @SerializedName("resultMsg")
    val resultMsg: String
)
