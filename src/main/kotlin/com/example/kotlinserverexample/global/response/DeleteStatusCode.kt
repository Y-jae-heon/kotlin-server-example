package com.example.kotlinserverexample.global.response

import org.springframework.http.HttpStatus

enum class DeleteStatusCode(
    val status: HttpStatus,
    val message: String,
) {
    MEMBER_DELETE(HttpStatus.OK, "MEMBER_DELETED")
}