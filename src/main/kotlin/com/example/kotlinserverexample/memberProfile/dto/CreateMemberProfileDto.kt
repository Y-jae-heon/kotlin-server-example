package com.example.kotlinserverexample.memberProfile.dto

import com.example.kotlinserverexample.member.entity.MemberEntity
import com.example.kotlinserverexample.memberProfile.entity.ImageKey
import com.example.kotlinserverexample.memberProfile.entity.MemberProfileEntity
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.NotNull

class CreateMemberProfileDto (
    @field:NotNull(message = "별칭은 필수값입니다.")
    var name: String,
    var memberId: Long,
    @Schema(hidden = true)
    var imageKey: ImageKey? = null,
) {
    fun toEntity(): MemberProfileEntity {
        return MemberProfileEntity(
            name = name,
            memberId = memberId,
            imageKey = imageKey,
        )
    }
}