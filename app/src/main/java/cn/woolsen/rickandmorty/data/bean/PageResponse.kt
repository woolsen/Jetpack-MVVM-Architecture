package cn.woolsen.rickandmorty.data.bean

data class PageResponse<T>(
    val info: PageInfo,
    val results: List<T>
)