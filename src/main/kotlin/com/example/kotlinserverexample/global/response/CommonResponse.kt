package com.example.kotlinserverexample.global.response


open class CommonResponse<T>(
    val status: Int,
    val message: String,
    val data: T? = null,
) {
}