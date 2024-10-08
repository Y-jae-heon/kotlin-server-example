package com.example.kotlinserverexample.member.controller

import com.example.kotlinserverexample.global.response.DeleteDetailResponse
import com.example.kotlinserverexample.global.response.DeleteResponse
import com.example.kotlinserverexample.global.response.DeleteStatusCode
import com.example.kotlinserverexample.member.dto.*
import com.example.kotlinserverexample.member.entity.MemberEntity
import com.example.kotlinserverexample.member.service.MemberService
import com.example.kotlinserverexample.memberProfile.service.MemberProfileService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springdoc.core.annotations.ParameterObject
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "Kotlin 예제 CRUD API", description = "Kt Example API")
@RestController
@RequestMapping("/member")
class MemberController(@Autowired var memberService: MemberService, var memberProfileService: MemberProfileService) {

    @Operation(summary = "TEST API MEMBER", description = "THIS IS TEST API")
    @PostMapping()
    fun createMember(@Validated @RequestBody memberDto: CreateMemberDto): MemberResponseDto {
        return memberService.save(memberDto)
    }

    @PutMapping("/{id}")
    fun updateMember(@PathVariable id: Long, @RequestBody updateMemberDto: UpdateMemberDto): MemberEntity {
        return memberService.update(id = id, updateMemberDto = updateMemberDto)
    }

    @GetMapping()
    fun searchMember(
        @Validated
        @ParameterObject memberSearchDto: MemberSearchDto,
        @ParameterObject @PageableDefault(size = 10) pageable: Pageable
    ): Page<MemberEntity> {
        return memberService.searchMember(memberSearchDto, pageable)
    }

    @GetMapping("/{id}")
    fun getDetailMember(
        @PathVariable id: Long
    ): MemberDetailDto {
        return memberService.getDetailMember(id)
    }

    @DeleteMapping("/{id}")
    fun deleteMember(@PathVariable id: Long): DeleteDetailResponse {
        memberService.delete(id)
        return DeleteResponse(DeleteStatusCode.MEMBER_DELETE).toDetails()
    }
}