package cn.woolsen.rickandmorty.data.bean

data class Character(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val image: String,
    val origin: Location,
    val location: Location
)