package com.triputranto.animehd.data.entity

import com.google.gson.annotations.SerializedName

data class Characters(
    @SerializedName("image_url") val image_url: String? = null,
    @SerializedName("name") val name: String? = null
)