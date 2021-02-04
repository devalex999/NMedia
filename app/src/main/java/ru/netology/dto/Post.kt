package ru.netology.dto

data class Post(
    val id: Long,
    val author: String,
    val content: String,
    val published: String,
    val likedByMe: Boolean = false,
    val countLike: Int,
    val countShare: Int,
    val countVisibility: Int
)
