package com.example.kotlinserverexample.member.repository

import com.example.kotlinserverexample.member.entity.MemberEntity
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository: JpaRepository<MemberEntity, Long> {
}