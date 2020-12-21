package cn.woolsen.rickandmorty.network

import cn.woolsen.rickandmorty.data.bean.Character
import cn.woolsen.rickandmorty.data.bean.PageResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterService {

    @GET("/api/character")
    suspend fun character(
        @Query("page") page: Int
    ): PageResponse<Character>

}