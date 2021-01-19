package ru.netology.dto

data class Post(
    val id: Long,
    val author: String,
    val content: String,
    var published: String,
    var likedByMe: Boolean = false,
    var countLike: Int,
    var countShare: Int,
    var countVisibility: Int = 0
)

