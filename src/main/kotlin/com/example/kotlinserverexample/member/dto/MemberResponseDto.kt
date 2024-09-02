package com.example.kotlinserverexample.member.dto

import jakarta.validation.constraints.NotNull
import java.time.LocalDateTime

class MemberResponseDto (
    var id: Long? = null,
    @field:NotNull(message = "이름은 필수값 입니다.")
    var name: String? = null,
    @field:NotNull(message = "나이는 필수값 입니다.")
    var age: Int? = null,
    var address: String? = null,
    var gender: String? = null,
    var createdAt: LocalDateTime = LocalDateTime.now(),
    var updatedAt: LocalDateTime = LocalDateTime.now()
) {
}