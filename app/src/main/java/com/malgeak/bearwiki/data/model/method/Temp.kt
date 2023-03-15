package com.malgeak.bearwiki.data.model.method


import com.google.gson.annotations.SerializedName

data class Temp(
    @SerializedName("unit")
    val unit: String,
    @SerializedName("value")
    val value: Int
)