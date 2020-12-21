package cn.woolsen.rickandmorty.ui.character

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import cn.woolsen.rickandmorty.repository.CharacterRepository

class CharacterViewModel @ViewModelInject constructor(
    private val characterRepository: CharacterRepository
): ViewModel() {

    val characters = characterRepository.character()
        .cachedIn(viewModelScope)

}