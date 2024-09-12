package com.example.kotlinserverexample.member.service

import com.example.kotlinserverexample.global.exception.Exception
import com.example.kotlinserverexample.global.exception.ExceptionCode
import com.example.kotlinserverexample.member.dto.*
import com.example.kotlinserverexample.member.entity.Gender
import com.example.kotlinserverexample.member.entity.MemberEntity
import com.example.kotlinserverexample.member.repository.MemberRepository
import com.example.kotlinserverexample.memberProfile.dto.MemberProfileResponseDto
import com.example.kotlinserverexample.memberProfile.service.MemberProfileService
import jakarta.transaction.Transactional
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.util.StringUtils
import java.time.LocalDateTime

@Service
class MemberService(private var memberRepository: MemberRepository, private var profileService: MemberProfileService) {

    fun getMember(id: Long): MemberEntity = memberRepository.findById(id).orElseThrow { Exception(ExceptionCode.MEMBER_NOT_FOUND) }
    fun searchMember(memberSearchDto: MemberSearchDto, pageable: Pageable): Page<MemberEntity> {

        return memberRepository.findByNameAndAgeAndAddressAndGender(memberSearchDto, pageable)
    }

    fun getDetailMember(id: Long): MemberDetailDto {
        val member = getMember(id)
        val profiles = profileService.searchProfiles(id)

        return MemberDetailDto.from(member = member,profiles = profiles)
    }


    @Transactional
    fun delete(id: Long) {
        val member = memberRepository.findById(id).orElseThrow { Exception(ExceptionCode.MEMBER_NOT_FOUND) }
        return memberRepository.delete(member)
    }

    @Transactional
    fun save(memberDto: CreateMemberDto): MemberResponseDto {
        val member = memberRepository.save(memberDto.toEntity())
        return member.createMember()
    }

    @Transactional
    fun update(id: Long, updateMemberDto: UpdateMemberDto): MemberEntity {
        val member = memberRepository.findById(id).orElseThrow { Exception(ExceptionCode.MEMBER_NOT_FOUND) }

        val name = updateMemberDto.name
        val age = updateMemberDto.age
        val address = updateMemberDto.address
        val gender = updateMemberDto.gender

        if (StringUtils.hasText(name)) {
            member.name = name
        }
        if (age !== null) {
            member.age = age
        }
        if (StringUtils.hasText(address)) {
            member.address = address
        }
        if (gender != null) {
            member.gender = gender
        }

        return member
    }
}