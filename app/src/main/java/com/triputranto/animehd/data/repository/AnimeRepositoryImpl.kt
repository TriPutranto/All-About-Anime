package com.triputranto.animehd.data.repository

import com.triputranto.animehd.data.entity.CharacterResponse
import com.triputranto.animehd.data.entity.Top
import com.triputranto.animehd.data.entity.TopResponse
import com.triputranto.animehd.data.remote.ApiService
import io.reactivex.Single

class AnimeRepositoryImpl(private val apiService: ApiService) : AnimeRepository {
    override fun setAllAnime(page: Int): Single<TopResponse> =
        apiService.getAllAnime(page)

    override fun setAnimeBySubtype(page: Int, subtype: String): Single<TopResponse> =
        apiService.getAnimeBySubtype(page, subtype)

    override fun setAnimeById(id: String): Single<Top> =
        apiService.getAnimeById(id)

    override fun setCharactersAnime(id: String): Single<CharacterResponse> =
        apiService.getCharactersAnime(id)
}