package com.ramanhmr.tmsandroid.homework17.response

import com.google.gson.annotations.SerializedName

data class FiatResponseEntity(
    @SerializedName("data") val data: List<FiatCurrencyEntity>,
    @SerializedName("status") val status: StatusEntity
)