package com.dmribeiro87.dragonballapi.repository

import com.dmribeiro87.dragonballapi.data.models.Character
import com.dmribeiro87.dragonballapi.data.remote.CharactersApiService

class CharactersRepository(
    private val apiService: CharactersApiService
) {

    suspend fun getCharacters(): List<Character> {
        val response = apiService.getCharacters()

        return if (response.isSuccessful){
            response.body()?.characters ?: emptyList()
        }else{
            emptyList()
        }
    }

}