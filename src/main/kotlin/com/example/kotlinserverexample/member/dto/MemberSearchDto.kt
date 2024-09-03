package com.example.kotlinserverexample.member.dto

import com.example.kotlinserverexample.member.entity.Gender

class MemberSearchDto(
    var name: String? = null,
    var age: Int? = null,
    var address: String? = null,
    var gender: Gender? = null
) {


}