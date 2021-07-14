package com.ramanhmr.tmsandroid.homework17.response

import com.google.gson.annotations.SerializedName

data class FiatCurrencyEntity(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("sign") val sign: String,
    @SerializedName("symbol") val symbol: String
)