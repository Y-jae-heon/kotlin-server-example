package com.example.kotlinserverexample.member.dto

import com.example.kotlinserverexample.member.entity.Gender
import com.example.kotlinserverexample.member.entity.MemberEntity
import jakarta.validation.constraints.NotNull

class CreateMemberDto (
    @field:NotNull(message = "이름은 필수값 입니다.")
    var name: String? = null,
    @field:NotNull(message = "나이는 필수값 입니다.")
    var age: Int? = null,
    var address: String? = null,
    var gender: Gender? = null,
) {
    fun toEntity(): MemberEntity {
        return MemberEntity(
            name = name,
            age = age,
            address = address,
            gender = gender,
        )
    }
}