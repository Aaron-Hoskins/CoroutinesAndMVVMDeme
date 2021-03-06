package com.examples.coding.networkingdemoone.model.ChuckNorrisResponse


import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable


@Parcelize
data class Value(
    @SerializedName("id")
    val id: Int,
    @SerializedName("joke")
    val joke: String
) : Parcelable