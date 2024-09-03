package com.example.kotlinserverexample.global.response

class ListResponse<T>(
    val count: Int? = null,
    message: String,
    data: T,
    status: Int,
): CommonResponse<T>(status, message, data) {

}