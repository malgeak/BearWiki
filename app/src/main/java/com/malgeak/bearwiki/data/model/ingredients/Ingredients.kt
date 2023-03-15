package com.malgeak.bearwiki.data.model.ingredients


import com.google.gson.annotations.SerializedName
import com.malgeak.bearwiki.data.model.ingredients.Hop
import com.malgeak.bearwiki.data.model.ingredients.Malt

data class Ingredients(
    @SerializedName("hops")
    val hops: List<Hop>,
    @SerializedName("malt")
    val malt: List<Malt>,
    @SerializedName("yeast")
    val yeast: String
)