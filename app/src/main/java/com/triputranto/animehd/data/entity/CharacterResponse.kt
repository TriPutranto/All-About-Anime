package com.triputranto.animehd.data.entity

import com.google.gson.annotations.SerializedName

data class CharacterResponse(
    @SerializedName("characters") val characters: ArrayList<Characters>
)