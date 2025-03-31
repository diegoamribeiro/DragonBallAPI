package com.dmribeiro87.dragonballapi.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dmribeiro87.dragonballapi.data.models.Character
import com.dmribeiro87.dragonballapi.repository.CharactersRepository
import kotlinx.coroutines.launch

class CharacterViewModel(
    private val repository: CharactersRepository
) : ViewModel() {

    private var _characters = MutableLiveData<List<Character>>()
    val characters: LiveData<List<Character>> = _characters

    init {
        getCharacters()
    }

    private fun getCharacters() {
        viewModelScope.launch {
            val charactersResponse = repository.getCharacters()
            if (charactersResponse.isNotEmpty()) {
                _characters.postValue(charactersResponse)
            }else{
                _characters.postValue(emptyList())
            }
        }
    }
}