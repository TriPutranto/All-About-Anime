package com.triputranto.animehd.data.repository

import com.triputranto.animehd.data.entity.CharacterResponse
import com.triputranto.animehd.data.entity.Top
import com.triputranto.animehd.data.entity.TopResponse
import io.reactivex.Single

interface AnimeRepository {
    fun setAllAnime(page: Int): Single<TopResponse>
    fun setAnimeBySubtype(page: Int, subtype: String): Single<TopResponse>
    fun setAnimeById(id: String): Single<Top>
    fun setCharactersAnime(id: String): Single<CharacterResponse>
}