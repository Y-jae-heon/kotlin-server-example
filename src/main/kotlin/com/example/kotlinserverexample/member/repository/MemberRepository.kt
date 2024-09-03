package com.example.kotlinserverexample.member.repository

import com.example.kotlinserverexample.global.response.PageResponse
import com.example.kotlinserverexample.member.entity.Gender
import com.example.kotlinserverexample.member.entity.MemberEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository: JpaRepository<MemberEntity, Long>, MemberRepositoryImpl {
}

interface MemberRepositoryImpl {
    fun findByNameAndAgeAndAddressAndGender(name: String?, age: Int?, address: String?, gender: Gender?, pageable: Pageable): Page<MemberEntity>
}