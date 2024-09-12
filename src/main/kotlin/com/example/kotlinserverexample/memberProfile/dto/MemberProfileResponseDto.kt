package com.example.kotlinserverexample.memberProfile.dto

import com.example.kotlinserverexample.memberProfile.entity.ImageKey
import jakarta.persistence.Column

class MemberProfileResponseDto(
    var id: Long? = null,
    var memberId: Long,
    var name: String? = null,
    var imageKey: ImageKey? = null,
) {
}