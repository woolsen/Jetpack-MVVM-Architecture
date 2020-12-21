package cn.woolsen.rickandmorty.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import cn.woolsen.rickandmorty.data.bean.Character
import cn.woolsen.rickandmorty.network.CharacterService
import cn.woolsen.rickandmorty.ui.character.CharacterPagingSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface CharacterRepository {
    fun character(): Flow<PagingData<Character>>
}

class CharacterRepositoryImpl @Inject constructor(
    private val service: CharacterService
) : CharacterRepository {

    override fun character(): Flow<PagingData<Character>> {
        val config = PagingConfig(pageSize = 20, initialLoadSize = 20)
        return Pager(config) {
            CharacterPagingSource(service)
        }.flow
    }

}
