package com.triputranto.animehd.data.remote

import com.triputranto.animehd.data.entity.CharacterResponse
import com.triputranto.animehd.data.entity.Top
import com.triputranto.animehd.data.entity.TopResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("top/anime/{page}")
    fun getAllAnime(
        @Path("page") page: Int
    ): Single<TopResponse>

    @GET("top/anime/{page}/{subtype}")
    fun getAnimeBySubtype(
        @Path("page") page: Int,
        @Path("subtype") subtype: String
    ): Single<TopResponse>

    @GET("anime/{id}/")
    fun getAnimeById(
        @Path("id") id: String
    ): Single<Top>

    @GET("anime/{id}/characters_staff")
    fun getCharactersAnime(
        @Path("id") id: String
    ): Single<CharacterResponse>
}