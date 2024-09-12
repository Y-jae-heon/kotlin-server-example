package com.example.kotlinserverexample.memberProfile.repository

import com.example.kotlinserverexample.member.dto.MemberResponseDto
import com.example.kotlinserverexample.member.repository.MemberRepositoryImpl
import com.example.kotlinserverexample.memberProfile.dto.MemberProfileResponseDto
import com.example.kotlinserverexample.memberProfile.entity.MemberProfileEntity
import org.springframework.data.jpa.repository.JpaRepository

interface MemberProfileRepository: JpaRepository<MemberProfileEntity, Long>, MemberProfileRepositoryImpl {
    fun findAllByMemberId(id: Long?): List<MemberProfileResponseDto>
}

interface MemberProfileRepositoryImpl {
//    fun findByMemberId(id: Long): MemberProfileEntity
}