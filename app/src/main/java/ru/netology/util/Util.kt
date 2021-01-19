package ru.netology.util

object Util {

    fun count(number: Int): String {
        return when (number) {
            in 0..999 -> number.toString()
            in 1_000..9_999 -> if ((number / 100) % 10 == 0) {
                (number / 1_000).toString() + "K"
            } else {
                String.format("%.1f", number * 1.0 / 1_000) + "K"
            }
            in 10_000..999_999 -> (number / 1_000).toString() + "K"
            else -> if ((number / 100_000) % 10 == 0) {
                (number / 1000_000).toString() + "M"
            } else {
                String.format("%.1f", number * 1.0 / 1000_000) + "M"
            }
        }
    }
}