package com.example.kotlinserverexample.global.exception

data class ErrorResponse(
    val status: Int,
    val error: String,
    val message: String?,
) {

}