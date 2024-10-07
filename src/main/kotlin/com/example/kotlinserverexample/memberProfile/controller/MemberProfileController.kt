package com.example.kotlinserverexample.memberProfile.controller

import com.example.kotlinserverexample.member.dto.CreateMemberDto
import com.example.kotlinserverexample.member.dto.MemberResponseDto
import com.example.kotlinserverexample.memberProfile.dto.CreateMemberProfileDto
import com.example.kotlinserverexample.memberProfile.dto.MemberProfileResponseDto
import com.example.kotlinserverexample.memberProfile.entity.MemberProfileEntity
import com.example.kotlinserverexample.memberProfile.entity.getRandomImageKey
import com.example.kotlinserverexample.memberProfile.service.MemberProfileService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/member/profile")
class MemberProfileController(@Autowired var memberProfileService: MemberProfileService) {
    @PostMapping()
    fun createMemberProfile(@Validated @RequestBody createMemberProfileDto: CreateMemberProfileDto): MemberProfileResponseDto {
        return memberProfileService.save(createMemberProfileDto)
    }

    @GetMapping()
    fun searchProfiles(id: Long): List<MemberProfileResponseDto> {
        return memberProfileService.searchProfiles(id)
    }
}