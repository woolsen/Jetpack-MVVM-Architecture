package cn.woolsen.rickandmorty.ui.character

import androidx.paging.PagingSource
import cn.woolsen.rickandmorty.data.bean.Character
import cn.woolsen.rickandmorty.network.CharacterService
import timber.log.Timber

class CharacterPagingSource(
    private val service: CharacterService
) : PagingSource<Int, Character>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        return try {
            val next = params.key ?: 1
            val response = service.character(next)
            LoadResult.Page(
                data = response.results,
                prevKey = null,
                nextKey = next + 1
            )
        } catch (e: Exception) {
            Timber.d(e)
            LoadResult.Error(e)
        }
    }
}