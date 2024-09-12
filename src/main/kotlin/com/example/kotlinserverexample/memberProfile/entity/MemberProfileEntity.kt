package com.example.kotlinserverexample.memberProfile.entity

import com.example.kotlinserverexample.member.dto.MemberResponseDto
import com.example.kotlinserverexample.memberProfile.dto.MemberProfileResponseDto
import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import org.hibernate.annotations.SoftDelete
import org.hibernate.annotations.SoftDeleteType

@Entity(name = "member_profile")
@SoftDelete(strategy = SoftDeleteType.DELETED)
class MemberProfileEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @field:NotNull(message = "유저의 아이디 정보는 필수입니다.")
    @Column(nullable = false, name = "member_id")
    var memberId: Long,

    @Column(nullable = false, length = 255)
    var name: String? = null,

    @Column(length = 255, name = "image_key")
    @Enumerated(EnumType.STRING)
    var imageKey: ImageKey? = null,
) {
    fun createMemberProfile(): MemberProfileResponseDto {
        return MemberProfileResponseDto(
            id,
            memberId,
            name,
            imageKey,
        )
    }
}