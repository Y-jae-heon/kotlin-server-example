package com.example.kotlinserverexample.member.entity

import com.example.kotlinserverexample.common.entity.Auditable
import com.example.kotlinserverexample.member.dto.MemberResponseDto
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
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
    var age: Int? = null,
    var address: String? = null,
    var gender: String? = null,
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