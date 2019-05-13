package com.uca.myapplication.movie

import android.os.Parcel
import android.os.Parcelable

data class Movie(
    val Name:String = "N/A",
    val Type1:String = "N/A",
    val Type2: String = "N/A",
    val weight:String = "N/A",
    val sprite:String = "N/A"
) : Parcelable {
    constructor(parcel: Parcel) : this(
        Name = parcel.readString(),
        Type1 = parcel.readString(),
        Type2 = parcel.readString(),
        weight = parcel.readString(),
        sprite = parcel.readString()

    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

        parcel.writeString(Name)
        parcel.writeString(Type1)
        parcel.writeString(Type2)
        parcel.writeString(weight)
        parcel.writeString(sprite)

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        @JvmField val CREATOR = object : Parcelable.Creator<Movie> {
            override fun createFromParcel(parcel: Parcel): Movie = Movie(parcel)
            override fun newArray(size: Int): Array<Movie?> = arrayOfNulls(size)
        }
    }
}