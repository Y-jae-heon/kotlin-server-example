package com.example.kotlinserverexample.member.controller

import com.example.kotlinserverexample.member.dto.CreateMemberDto
import com.example.kotlinserverexample.member.dto.MemberResponseDto
import com.example.kotlinserverexample.member.dto.UpdateMemberDto
import com.example.kotlinserverexample.member.entity.MemberEntity
import com.example.kotlinserverexample.member.service.MemberService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "Kotlin 예제 CRUD API", description = "Kt Example API")
@RestController
@RequestMapping("/member")
class MemberController(@Autowired var memberService: MemberService) {

    @Operation(summary = "TEST API MEMBER", description = "THIS IS TEST API")
    @PostMapping()
    fun createMember(@Validated @RequestBody memberDto: CreateMemberDto): MemberResponseDto {
        return memberService.save(memberDto)
    }

    @PutMapping("/{id}")
    fun updateMember(@PathVariable id: Long, @RequestBody updateMemberDto: UpdateMemberDto): MemberEntity {
        return memberService.update(id = id, updateMemberDto = updateMemberDto)
    }
}