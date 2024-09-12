package com.example.kotlinserverexample.member.entity

import com.example.kotlinserverexample.common.entity.Auditable
import com.example.kotlinserverexample.global.annotation.Numeric
import com.example.kotlinserverexample.member.dto.MemberResponseDto
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Positive
import lombok.Getter
import org.hibernate.annotations.SoftDelete
import org.hibernate.annotations.SoftDeleteType

@Entity(name = "member")
@SoftDelete(strategy = SoftDeleteType.DELETED)
class MemberEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false, length = 255)
    var name: String? = null,

    @Column(nullable = false, length = 255)
//    @field:Min(value = 10, message = "0이상만")
//    @field:Numeric(message = "나이는 숫자만 입력 가능합니다.")
    var age: Int? = null,
    var address: String? = null,

    @Enumerated(EnumType.STRING)
    var gender: Gender? = null,
): Auditable() {
    fun createMember(): MemberResponseDto {
        return MemberResponseDto(
            id,
            name,
            age,
            address,
            gender,
            createdAt,
            updatedAt
        )
    }
}