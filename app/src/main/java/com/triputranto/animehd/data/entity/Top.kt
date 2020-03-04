package com.triputranto.animehd.data.entity

import com.google.gson.annotations.SerializedName

data class Top(
    @SerializedName("mal_id") val id: String? = null,
    @SerializedName("rank") val rank: String? = null,
    @SerializedName("title") val title: String? = null,
    @SerializedName("image_url") val image_url: String? = null,
    @SerializedName("type") val type: String? = null,
    @SerializedName("episodes") val episodes: String? = null,
    @SerializedName("start_date") val start_date: String? = null,
    @SerializedName("end_date") val end_date: String? = null,
    @SerializedName("score") val score: Double? = null,
    @SerializedName("duration") val duration: String? = null,
    @SerializedName("synopsis") val synopsis: String? = null
)