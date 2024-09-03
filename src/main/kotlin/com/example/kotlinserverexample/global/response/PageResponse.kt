package com.example.kotlinserverexample.global.response


class PageResponse<T>(
    val count: Int? = null,
    val total: Long? = null,
    val totalPage: Int? = null,
    message: String,
    data: T,
    status: Int,
): CommonResponse<T>(status, message, data) {
}