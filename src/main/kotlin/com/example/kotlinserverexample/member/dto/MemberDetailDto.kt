package com.example.kotlinserverexample.member.dto

import com.example.kotlinserverexample.member.entity.Gender
import com.example.kotlinserverexample.member.entity.MemberEntity
import com.example.kotlinserverexample.memberProfile.dto.MemberProfileResponseDto
import jakarta.validation.constraints.NotNull
import java.time.LocalDateTime

data class MemberDetailDto(
    val id: Long? = null,
    @field:NotNull(message = "이름은 필수값 입니다.")
    val name: String? = null,
    @field:NotNull(message = "나이는 필수값 입니다.")
    val age: Int? = null,
    val address: String? = null,
    val gender: Gender? = null,
    val profiles: List<MemberProfileResponseDto>,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime = LocalDateTime.now()
) {
    companion object {
        fun from(member: MemberEntity, profiles: List<MemberProfileResponseDto>): MemberDetailDto {
            return MemberDetailDto(
                id = member.id,
                name = member.name,
                age = member.age,
                address = member.address,
                gender = member.gender,
                profiles = profiles,
                createdAt = member.createdAt,
                updatedAt = member.updatedAt
            )
        }
    }
}