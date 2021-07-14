package com.ramanhmr.tmsandroid.homework17.response

import com.google.gson.annotations.SerializedName

data class QuotesEntity(
    @SerializedName("time_open") val timeOpen: String,
    @SerializedName("time_close") val timeClose: String,
    @SerializedName("time_high") val timeHigh: String,
    @SerializedName("time_low") val timeLow: String,
    @SerializedName("quote") val quote: QuoteEntity
)