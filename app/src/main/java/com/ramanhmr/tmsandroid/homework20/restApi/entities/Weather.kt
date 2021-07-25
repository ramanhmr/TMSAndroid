package com.ramanhmr.tmsandroid.homework20.restApi.entities

import android.os.Parcel
import android.os.Parcelable

data class Weather(
    val temperature: String,
    val description: String,
    val windSpeed: String,
    val windDirection: String,
    val cityName: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(temperature)
        parcel.writeString(description)
        parcel.writeString(windSpeed)
        parcel.writeString(windDirection)
        parcel.writeString(cityName)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Weather> {
        override fun createFromParcel(parcel: Parcel): Weather {
            return Weather(parcel)
        }

        override fun newArray(size: Int): Array<Weather?> {
            return arrayOfNulls(size)
        }
    }
}