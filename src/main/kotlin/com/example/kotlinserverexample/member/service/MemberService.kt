package com.example.kotlinserverexample.member.service

import com.example.kotlinserverexample.member.dto.CreateMemberDto
import com.example.kotlinserverexample.member.dto.MemberResponseDto
import com.example.kotlinserverexample.member.dto.UpdateMemberDto
import com.example.kotlinserverexample.member.entity.MemberEntity
import com.example.kotlinserverexample.member.repository.MemberRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import org.springframework.util.StringUtils

@Service
class MemberService(private  var memberRepository: MemberRepository) {

    @Transactional
    fun save(memberDto: CreateMemberDto): MemberResponseDto {
        val member = memberRepository.save(memberDto.toEntity())
        return member.createMember()
    }

    @Transactional
    fun update(id: Long, updateMemberDto: UpdateMemberDto): MemberEntity {
        val member = memberRepository.findById(id).orElseThrow()

        val name = updateMemberDto.name
        val age = updateMemberDto.age
        val address = updateMemberDto.address
        val gender = updateMemberDto.gender

        if(StringUtils.hasText(name)) {
            member.name = name
        }
        if(age !== null) {
            member.age = age
        }
        if(StringUtils.hasText(address)) {
            member.address = address
        }
        if(StringUtils.hasText(gender)) {
            member.gender = gender
        }

        return member
    }
}