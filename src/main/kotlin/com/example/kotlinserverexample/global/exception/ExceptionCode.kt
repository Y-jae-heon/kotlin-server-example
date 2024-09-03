package com.example.kotlinserverexample.global.exception

import org.springframework.http.HttpStatus

enum class ExceptionCode(
    val status: HttpStatus,
    val message: String,
) {
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "유저 정보가 없습니다.")
}