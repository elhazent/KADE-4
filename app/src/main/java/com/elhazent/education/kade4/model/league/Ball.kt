package com.elhazent.education.kade4.model.league



import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Ball(var id: String?, var name: String?, var desc: String?, var image: Int) : Parcelable {

}