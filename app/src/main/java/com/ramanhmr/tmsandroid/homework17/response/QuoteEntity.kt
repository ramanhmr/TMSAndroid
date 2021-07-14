package com.ramanhmr.tmsandroid.homework17.response

import com.google.gson.annotations.SerializedName

data class QuoteEntity(
    @SerializedName("open") val open: Long,
    @SerializedName("high") val high: Long,
    @SerializedName("low") val low: Long,
    @SerializedName("close") val close: Long,
    @SerializedName("volume") val volume: Long,
    @SerializedName("market_cap") val marketCap: Long,
    @SerializedName("timestamp") val timestamp: String
)