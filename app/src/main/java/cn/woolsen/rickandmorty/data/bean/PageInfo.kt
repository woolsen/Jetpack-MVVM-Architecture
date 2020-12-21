package cn.woolsen.rickandmorty.data.bean

data class PageInfo(
    var count: Int,
    var pages: Int,
    var next: String?,
    var prev: String?
)