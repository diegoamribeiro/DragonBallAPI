package com.dmribeiro87.dragonballapi.data.models


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Meta(
    @SerializedName("currentPage")
    val currentPage: Int,
    @SerializedName("itemCount")
    val itemCount: Int,
    @SerializedName("itemsPerPage")
    val itemsPerPage: Int,
    @SerializedName("totalItems")
    val totalItems: Int,
    @SerializedName("totalPages")
    val totalPages: Int
) : Parcelable