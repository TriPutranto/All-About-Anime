package com.triputranto.animehd.data.entity

import com.google.gson.annotations.SerializedName

data class TopResponse(
    @SerializedName("top") val top: ArrayList<Top>
)