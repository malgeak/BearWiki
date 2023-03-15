package com.malgeak.bearwiki.data.model.method


import com.google.gson.annotations.SerializedName

data class MashTemp(
    @SerializedName("duration")
    val duration: Int,
    @SerializedName("temp")
    val temp: Temp
)