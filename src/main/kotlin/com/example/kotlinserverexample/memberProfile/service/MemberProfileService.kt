package com.example.kotlinserverexample.memberProfile.service

import com.example.kotlinserverexample.member.dto.MemberResponseDto
import com.example.kotlinserverexample.memberProfile.dto.CreateMemberProfileDto
import com.example.kotlinserverexample.memberProfile.dto.MemberProfileResponseDto
import com.example.kotlinserverexample.memberProfile.entity.MemberProfileEntity
import com.example.kotlinserverexample.memberProfile.entity.getRandomImageKey
import com.example.kotlinserverexample.memberProfile.repository.MemberProfileRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class MemberProfileService(private var memberProfileRepository: MemberProfileRepository) {

    @Transactional
    fun save(createMemberProfileDto: CreateMemberProfileDto): MemberProfileResponseDto {
        createMemberProfileDto.imageKey = getRandomImageKey()
        val profile = memberProfileRepository.save(createMemberProfileDto.toEntity())

        return profile.createMemberProfile()
    }

    fun searchProfiles(id: Long?): List<MemberProfileResponseDto> {
        return memberProfileRepository.findAllByMemberId(id);
    }
}