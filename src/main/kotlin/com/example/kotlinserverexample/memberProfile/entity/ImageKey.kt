package com.example.kotlinserverexample.memberProfile.entity

import kotlin.random.Random

enum class ImageKey {
    IMAGE_1,
    IMAGE_2,
    IMAGE_3,
    IMAGE_4,
    IMAGE_5
}

fun getRandomImageKey(): ImageKey {
    val values = ImageKey.values()
    return values[Random.nextInt(values.size)]
}