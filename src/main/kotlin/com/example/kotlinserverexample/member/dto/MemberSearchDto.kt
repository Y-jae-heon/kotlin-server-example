package com.example.kotlinserverexample.member.dto

import com.example.kotlinserverexample.global.annotation.Numeric
import com.example.kotlinserverexample.member.entity.Gender
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Positive
import lombok.Getter
import lombok.Setter

class MemberSearchDto(
    var name: String? = null,
//    @field:Pattern(regexp = "^[0-9]+$", message = "숫자만 입력 가능합니다.")
//    @field:(message = "숫자만 입력 가능합니다.")
//    @field:Min(message = "나이는 0보다 커야 합니다.", value = 10)
//    @field:Min(10)
//    @field:Max(message = "나이는 2000보다 작아야 합니다.", value = 200)
//    @field:Numeric(message = "나이는 숫자만 입력 가능합니다.")
//    @field:URL
    var age: Int? = null,
    var address: String? = null,
    var gender: Gender? = null
) {


}