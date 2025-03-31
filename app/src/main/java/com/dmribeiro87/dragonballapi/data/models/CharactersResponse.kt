package com.dmribeiro87.dragonballapi.data.models


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class CharactersResponse(
    @SerializedName("items")
    val characters: List<Character>,
    @SerializedName("links")
    val links: Links,
    @SerializedName("meta")
    val meta: Meta
) : Parcelable