package com.dmribeiro87.dragonballapi.data.models


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import java.io.Serial
import java.io.Serializable


data class Character(
    @SerializedName("affiliation")
    val affiliation: String,
    @SerializedName("deletedAt")
    val deletedAt: String? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("gender")
    val gender: String? = null,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String? = null,
    @SerializedName("ki")
    val ki: String? = null,
    @SerializedName("maxKi")
    val maxKi: String? = null,
    @SerializedName("name")
    val name: String,
    @SerializedName("race")
    val race: String? = null
) : Serializable