package com.dmribeiro87.dragonballapi.data.remote


import com.dmribeiro87.dragonballapi.data.models.CharactersResponse
import retrofit2.Response
import retrofit2.http.GET

interface CharactersApiService {

    @GET("characters")
    suspend fun getCharacters() : Response<CharactersResponse>

}